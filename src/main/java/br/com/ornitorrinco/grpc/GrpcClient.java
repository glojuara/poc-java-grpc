package br.com.ornitorrinco.grpc;

import generated.ApiResponse;
import generated.LoginRequest;
import generated.UserGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class GrpcClient {

    public static void main(String[] args) {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8080)
                .usePlaintext()
                .build();

        UserGrpc.UserBlockingStub stub = UserGrpc.newBlockingStub(channel);

        ApiResponse response = stub.login(LoginRequest.newBuilder()
                .setUsername("123")
                .setPassword("123")
                .build());

        System.out.println(response.getResponseMessage());

        channel.shutdown();
    }

}
