package loadBalance;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.Server;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class MyLoadBalance extends AbstractLoadBalancerRule {

    private AtomicInteger integer = new AtomicInteger(0);

    @Override
    public void initWithNiwsConfig(IClientConfig clientConfig) {

    }

    @Override
    public Server choose(Object key) {
        List<Server> reachableServers = getLoadBalancer().getReachableServers();
        if (reachableServers.size() == 0) {
            return null;
        }
        int count = integer.incrementAndGet();
        System.out.println("第 " + count + "次请求。。。");
        return reachableServers.get(count % reachableServers.size());
    }
}
