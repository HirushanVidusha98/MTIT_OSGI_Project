package com;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

import adminService.AdminService;
import adminServiceImpl.AdminServiceImpl;

public class Activator implements BundleActivator {

	ServiceRegistration serviceRegisterr;

	@Override
	public void start(BundleContext context) throws Exception {
		System.out.println("============School service started.============");
		AdminService managerSer = new AdminServiceImpl();
		serviceRegisterr = context.registerService(AdminService.class.getName(), managerSer, null); 
	}

	public void stop(BundleContext bundleContext) throws Exception {
		System.out.println("==============School service closed.=============");
		serviceRegisterr.unregister();
	}
}
