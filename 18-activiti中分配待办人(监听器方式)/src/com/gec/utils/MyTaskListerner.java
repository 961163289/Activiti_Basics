package com.gec.utils;

import org.activiti.engine.delegate.DelegateTask;
import org.activiti.engine.delegate.TaskListener;

public class MyTaskListerner implements TaskListener{

	@Override
	public void notify(DelegateTask delegate) {
		
		delegate.setAssignee("–°¿Ó");
		
	}

}
