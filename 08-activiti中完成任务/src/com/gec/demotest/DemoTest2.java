package com.gec.demotest;



import java.util.List;


import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
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
	}
	
	
	//3.查看任务列表
	@Test
	public void fun3(){
		String assignee = "潘金莲";
		List<Task> list = this.processEngine
		//与正在执行的任务管理相关的Service
		.getTaskService()
		//创建任务查询对象
		.createTaskQuery()
		//指定个人任务查询,指定办理人
		.taskAssignee(assignee)
		.list();
		
		if (list!=null&&list.size()>0) {
			for (Task task : list) {
				System.out.println("任务的id:"+task.getId());//104
				System.out.println("任务的名称:"+task.getName());//提交申请
				System.out.println("任务的待办人:"+task.getAssignee());//小明
				System.out.println("任务的创建时间:"+task.getCreateTime());//Sun May 16 19:45:22 CST 2021
				System.out.println("流程实例的id:"+task.getProcessInstanceId());//101
				System.out.println("流程定义的id:"+task.getProcessDefinitionId());//helloworldProcess:1:4
			}
		}
	}
	
	
	//4.完成任务 complete(String taskId)
	@Test
	public void fun4(){
		String taskId = "302";
		this.processEngine.getTaskService()
		.complete(taskId);
		System.out.println("任务已经完成...");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
