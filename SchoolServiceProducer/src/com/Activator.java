package com;

import org.osgi.framework.ServiceRegistration;

import parentService.ParentService;
import parentServiceImpl.ParentServiceImpl;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class Activator implements BundleActivator {

	ServiceRegistration serviceRegister;

	@Override
	public void start(BundleContext context) throws Exception {//Life cycle method-start
		System.out.println("============School service started.============");
		ParentService managerSer = new ParentServiceImpl();
		serviceRegister = context.registerService(ParentService.class.getName(), managerSer, null); 
	}

	public void stop(BundleContext bundleContext) throws Exception {
		System.out.println("==============School service closed.=============");
		serviceRegister.unregister();
	}

}
