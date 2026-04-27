package LLD_Khauf_coder.proxy.API_Rate_Limiting.proxy;

import LLD_Khauf_coder.proxy.API_Rate_Limiting.ApiService;
import LLD_Khauf_coder.proxy.API_Rate_Limiting.Impl.RealAoiServiceImpl;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import java.util.concurrent.*;

public class ApiProxy implements ApiService {

    private final ApiService realService;

    private static final ConcurrentHashMap<String, AtomicInteger> requestCount = new ConcurrentHashMap<>();

    private static final int LIMIT = 5;

    public ApiProxy() {
        this.realService = new RealAoiServiceImpl();
    }

    public String fetchData(String userId) {

        // ✅ Atomic increment (thread-safe)
        requestCount.putIfAbsent(userId, new AtomicInteger(0));
        int count = requestCount.get(userId).incrementAndGet();

        if (count > LIMIT) {
            return "Rate limit exceeded!";
        }

        return realService.fetchData(userId);
    }
}

