package org.ragna.kalin.ch01.ts;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class MyThreadPool extends ThreadPoolExecutor {
	private static final int POOL_SIZE = 10;
	private boolean is_paused;
	private ReentrantLock pause_lock = new ReentrantLock();
	private Condition unpaused = pause_lock.newCondition();

	public MyThreadPool() {
		super(POOL_SIZE // core poo; size
				, POOL_SIZE // max pool_size
				, 0L // keep-alive time for idle thread
				, TimeUnit.SECONDS // time unit for keep_alive
				, new LinkedBlockingQueue<Runnable>(POOL_SIZE) // work queue
		);
	}

	protected void beforeExecute(Thread t, Runnable r) {
		super.beforeExecute(t, r);
		pause_lock.lock();
		try {
			while (is_paused) {
				unpaused.await();
			}
		} catch (InterruptedException e) {
			t.interrupt();
		} finally {
			pause_lock.unlock();
		}
	}

	public void resume() {
		pause_lock.lock();
		try {
			is_paused = false;
			unpaused.signalAll();
		} finally {
			pause_lock.unlock();
		}
	}

}
