package songhq.club.factory;

//静态工厂方法实例化bean
public class ClientService {
	
	private static ClientService clientService = new ClientService();
	
    private ClientService() {}

    public static ClientService createInstance() {
        return clientService;
    }

}
