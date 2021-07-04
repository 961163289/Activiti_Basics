package com.gec.demotest;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.runtime.ProcessInstance;
import org.junit.Test;

public class DemoTest2 {
	
	// 流程引擎对象
	ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
	
	//1.流程部署
	@Test
	public void fun1() {
		
		//小弟(各种服务)
		//返回得到部署对象
		Deployment deployment = processEngine.getRepositoryService()
		//创建部署对象		
		.createDeployment()
		//部署名称
		.name("第一个流程部署测试")
		//从类路径下加载配置文件
		.addClasspathResource("digram/HelloWorld.bpmn")
		.addClasspathResource("digram/HelloWorld.png")
		//调用部署方法
		.deploy();
		
		System.out.println("部署id:"+deployment.getId());     //1
		System.out.println("部署name:"+deployment.getName()); //第一个流程部署测试
		
	}
	
	
	//2.启动流程(从开始推向到第一个任务这里来)
	@Test
	public void fun2(){
		String processDefinitionKey = "helloworldProcess";
		ProcessInstance processInstance = processEngine.getRuntimeService()
		.startProcessInstanceByKey(processDefinitionKey);
		
		System.out.println("启动流程成功...");
		
		//启动后,哪些表会发生变化?
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
