package com.marilia.picpay.service;

import com.marilia.picpay.client.AuthorizationClient;
import com.marilia.picpay.controller.dto.TransferDto;
import com.marilia.picpay.exception.PicPayException;
import org.springframework.stereotype.Service;

@Service
public class AuthorizationService {

    private final AuthorizationClient authorizationClient;

    public AuthorizationService(AuthorizationClient authorizationClient) {
        this.authorizationClient = authorizationClient;
    }

    public boolean isAuthorized(TransferDto transfer) {

        var resp = authorizationClient.isAuthorized();

        if (resp.getStatusCode().isError()) {
            throw new PicPayException();
        }

        return resp.getBody().data().authorization();
    }
}
