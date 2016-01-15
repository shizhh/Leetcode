package thread;

import java.io.*;
import java.util.*;
import java.util.concurrent.*;

public class ThreadPoolTest {

	public static void main(String[] args) throws Exception {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter base directory : ");
		String directory = in.nextLine();
		System.out.println("Enter keyword :");
		String keyword = in.nextLine();

		ExecutorService pool = Executors.newCachedThreadPool();

		MatchCounter counter = new MatchCounter(new File(directory), keyword, pool);
		Future<Integer> result = pool.submit(counter);

		try {
			System.out.println(result.get() + " matching files.");
		} catch (ExecutionException e) {

		} catch (InterruptedException ex) {

		}
		pool.shutdown();

		int largestPoolSize = ((ThreadPoolExecutor) pool).getLargestPoolSize();
		System.out.println("largest pool size=" + largestPoolSize);
	}
}

/**
 * This task counts the files in a directory and its subdirectories that contain
 * a given keyword.
 */
class MatchCounter implements Callable<Integer> {
	private File directory;
	private String keyword;
	private ExecutorService pool;
	private int count;

	/**
	 * Constructs a MatchCounter.
	 */
	public MatchCounter(File directory, String keyword, ExecutorService pool) {
		this.directory = directory;
		this.keyword = keyword;
		this.pool = pool;
	}

	public Integer call() {
		count = 0;
		try {
			File[] files = directory.listFiles();
			List<Future<Integer>> results = new ArrayList<>();

			for (File file : files)
				if (file.isDirectory()) {
					MatchCounter counter = new MatchCounter(file, keyword, pool);
					Future<Integer> result = pool.submit(counter);
					results.add(result);
				} else {
					if (search(file))
						count++;
				}
			for (Future<Integer> result : results) {
				try {
					count += result.get();
				} catch (ExecutionException e) {
					e.printStackTrace();
				}
			}
		} catch (InterruptedException e) {
		}
		return count;
	}

	/**
	 * Searches a file for a given keyword.
	 */
	public boolean search(File file) {
		try {
			try (Scanner in = new Scanner(file)) {
				boolean found = false;
				while (!found && in.hasNextLine()) {
					String line = in.nextLine();
					if (line.contains(keyword))
						found = true;
				}
				return found;
			}
		} catch (IOException e) {
			return false;
		}
	}
}
