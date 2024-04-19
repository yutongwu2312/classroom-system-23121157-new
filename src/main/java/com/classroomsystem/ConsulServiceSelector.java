package com.classroomsystem;

import com.google.common.net.HostAndPort;
import com.orbitz.consul.Consul;
import com.orbitz.consul.HealthClient;
import com.orbitz.consul.model.ConsulResponse;
import com.orbitz.consul.model.health.Service;
import com.orbitz.consul.model.health.ServiceHealth;

import java.util.List;
import java.util.Random;

// Consul服务选择器
public class ConsulServiceSelector {

    public static final String computerServiceName = "computer-service";

    public static final String lightServiceName = "light-service";

    public static final String mobileServiceName = "mobile-service";

    public static final String defaultConsulHost = "localhost";

    public static final String defaultConsulPort = "8500";

   // 获取随机服务实例
    public static Service getRandomServiceInstance(String serviceName,String consulHost,int consulPort) throws RuntimeException{
        /**
         * 使用Consul查找并随机选择一个指定服务的信息。
         * 该方法首先连接到本地运行的Consul服务器（默认地址为localhost，端口为8500），
         * 然后查询名为"computer-service"的服务的所有实例，
         * 并从中随机选择一个服务实例进行输出。
         */
        Consul consul = Consul.builder().withHostAndPort(HostAndPort.fromParts(consulHost, consulPort)).build(); // 建立与Consul服务器的连接

        try{
            HealthClient healthClient = consul.healthClient();

            // 查询指定服务的所有实例
            ConsulResponse<List<ServiceHealth>> allServiceInstances = healthClient.getAllServiceInstances(serviceName);
            List<ServiceHealth> serviceList = allServiceInstances.getResponse();

            // 如果有找到服务实例，随机选择并输出一个实例的信息
            if (!serviceList.isEmpty()) {
                Random random = new Random();
                int randomIndex = random.nextInt(serviceList.size()); // 生成随机索引
                ServiceHealth serviceHealth = serviceList.get(randomIndex);// 根据随机索引获取实例
                System.out.println("Randomly selected service: " + serviceHealth);

                // 输出所选服务的地址和端口
                String address = serviceHealth.getService().getAddress();
                int port = serviceHealth.getService().getPort();
                System.out.println("Address: " + address);
                System.out.println("Port: " + port);

                return serviceHealth.getService();
            } else {
                // 如果未找到任何服务实例，输出提示信息
                System.out.println("No services found for the specified name.");

                throw new RuntimeException("No services found for the specified name.");
            }
        }finally {
            // 关闭与Consul的连接
            consul.destroy();
        }
    }


}