package hu.daniel.hari.exercises.cleanarchitecture.payrollcasestudy.ui.swing;

import java.awt.EventQueue;
import java.util.concurrent.Executor;

import javax.swing.SwingUtilities;

import com.google.common.eventbus.AsyncEventBus;

public class EventQueueAsyncEventBus extends AsyncEventBus {

	public EventQueueAsyncEventBus() {
		super(new EventQueueExecutor());
	}

	@Override
	public void post(Object event) {
		SwingUtilities.invokeLater(() -> 
			super.post(event)
		);
	}
	
	private static class EventQueueExecutor implements Executor {
		@Override
		public void execute(Runnable command) {
			EventQueue.invokeLater(command);
		}
	}

}
