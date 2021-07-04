package com.gec.demotest;



import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;
import java.util.zip.ZipInputStream;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.junit.Test;

public class DemoTest5 {
	
	// �����������
	ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
	
	//1.���̲���
	@Test
	public void fun1() {
		
		//С��(���ַ���)
		//���صõ��������
//		InputStream in = new FileInputStream(file);
		
		//ͨ�����䷽ʽ��һ���ļ�תΪinputstream
		InputStream in = this.getClass().getClassLoader().getResourceAsStream("digram/helloworldProcess.zip");
		
		ZipInputStream zipInputStream = new ZipInputStream(in);
		Deployment deployment = processEngine.getRepositoryService()
		.createDeployment()
		.name("ѹ�����������")
		.addZipInputStream(zipInputStream)
		.deploy();
		
		System.out.println("����id:"+deployment.getId());
		System.out.println("����name:"+deployment.getName());
		
	    
		
		
	}
	
	
	//2.��������(�ӿ�ʼ���򵽵�һ������������)
	@Test
	public void fun2(){
		String processDefinitionKey = "helloworldProcess";
		ProcessInstance processInstance = processEngine.getRuntimeService()
		.startProcessInstanceByKey(processDefinitionKey);
		System.out.println("�������̳ɹ�...");
	}
	
	
	//3.�鿴�����б�
	@Test
	public void fun3(){
		String assignee = "�˽���";
		List<Task> list = this.processEngine
		//������ִ�е����������ص�Service
		.getTaskService()
		//���������ѯ����
		.createTaskQuery()
		//ָ�����������ѯ,ָ��������
		.taskAssignee(assignee)
		.list();
		
		if (list!=null&&list.size()>0) {
			for (Task task : list) {
				System.out.println("�����id:"+task.getId());//104
				System.out.println("���������:"+task.getName());//�ύ����
				System.out.println("����Ĵ�����:"+task.getAssignee());//С��
				System.out.println("����Ĵ���ʱ��:"+task.getCreateTime());//Sun May 16 19:45:22 CST 2021
				System.out.println("����ʵ����id:"+task.getProcessInstanceId());//101
				System.out.println("���̶����id:"+task.getProcessDefinitionId());//helloworldProcess:1:4
			}
		}
	}
	
	
	//4.������� complete(String taskId)
	@Test
	public void fun4(){
		String taskId = "602";
		this.processEngine.getTaskService()
		.complete(taskId);
		System.out.println("�����Ѿ����...");
	}
	
	
	
	//��ѯ���̶����б�
	@Test
	public void fun5(){
		List<ProcessDefinition> list = this.processEngine.getRepositoryService()
		.createProcessDefinitionQuery()
		//����version�汾
		.orderByProcessDefinitionVersion()
		//��������
		.desc()
		//�õ����̶����б�list����
		.list();
		
		if (list!=null&&list.size()>0) {
			//ProcessDefinition  -> act_re_procdef
			for (ProcessDefinition processDefinition : list) {
				System.out.println("processDefinition.getKey()=="+processDefinition.getKey());
				System.out.println("processDefinition.getVersion()=="+processDefinition.getVersion());
				System.out.println("processDefinition.getName()"+processDefinition.getName());
				System.out.println("processDefinition.getResourceName()"+processDefinition.getResourceName());
				System.out.println("processDefinition.getDiagramResourceName()"+processDefinition.getDiagramResourceName());
				
			}
		}
	}
	
	
	
	//��ѯ���̲�����Ϣ
	@Test
	public void fun6(){
		List<Deployment> list = this.processEngine
		.getRepositoryService()
		.createDeploymentQuery()
		.orderByDeploymentId()
		.desc()
		.list();
		
		//Deployment -> act_re_deployment
		for (Deployment deployment : list) {
			System.out.println("����name:"+deployment.getName());
			System.out.println("����id"+deployment.getId());
			System.out.println("����ʱ��:"+deployment.getDeploymentTime());
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
