package br.com.ornitorrinco.grpc.service;

import generated.ApiResponse;
import generated.Empty;
import generated.LoginRequest;
import generated.UserGrpc;
import io.grpc.stub.StreamObserver;

public class UserService extends UserGrpc.UserImplBase {

    @Override
    public void login(LoginRequest request, StreamObserver<ApiResponse> responseObserver) {
        String username = request.getUsername();
        String password = request.getPassword();

        ApiResponse.Builder response = ApiResponse.newBuilder();
        if (username.equals(password)){
            response.setResponseMessage("Sucesso").setResponseCode(200);
        } else {
            response.setResponseMessage("Falha ao efetuar o login").setResponseCode(400);
        }

        responseObserver.onNext(response.build());
        responseObserver.onCompleted();
    }

    @Override
    public void logout(Empty request, StreamObserver<ApiResponse> responseObserver) {
        super.logout(request, responseObserver);
    }
}
