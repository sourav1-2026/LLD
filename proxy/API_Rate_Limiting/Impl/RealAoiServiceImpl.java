package LLD_Khauf_coder.proxy.API_Rate_Limiting.Impl;

import LLD_Khauf_coder.proxy.API_Rate_Limiting.ApiService;

public class RealAoiServiceImpl implements ApiService {
    @Override
    public String fetchData(String request) {
        return "Data for user: " + request;
    }
}
