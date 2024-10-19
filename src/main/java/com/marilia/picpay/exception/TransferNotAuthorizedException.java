package com.marilia.picpay.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;

public class TransferNotAuthorizedException extends PicPayException {
    public ProblemDetail toProblemDetail() {
        var pb = ProblemDetail.forStatus(HttpStatus.UNPROCESSABLE_ENTITY);

        pb.setTitle("Unauthorized Transfer.");
        pb.setDetail("Authorization service did not authorize this transfer");

        return pb;
    }
}
