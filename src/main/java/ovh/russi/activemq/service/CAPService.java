package ovh.russi.activemq.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ovh.russi.activemq.helper.CAPHelper;

@Service
public class CAPService {

    @Autowired
    private CAPHelper capHelper;
}
