package org.telran.validationexample.com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("transfers")
public class TransferService {

    @Autowired
    private TransferService transferService;

    @PutMapping("/{sum}/{from}/{to}")
    public void transfer(@PathVariable (name = "sum")long sum, @PathVariable(name = "from") long from, @PathVariable(name = "to") long to){
        transferService.transfer(sum, from, to);
    }
}
