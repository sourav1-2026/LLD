package LLD_Khauf_coder.proxy.Proxy_Decorator.proxy.Impl;

import LLD_Khauf_coder.proxy.API_Rate_Limiting.ApiService;

public class RealService implements ApiService {
    @Override
    public String fetchData(String request) {
        return "Processing request: " + request;
    }

}
