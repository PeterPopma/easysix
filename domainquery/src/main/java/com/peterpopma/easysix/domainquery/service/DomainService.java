package com.peterpopma.easysix.domainquery.service;

import com.peterpopma.easysix.domainquery.dto.AuthInfo;
import com.peterpopma.easysix.domainquery.dto.DomainObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Value;

@Slf4j
@Service
public class DomainService {

    @Value("${service.simulated-workload}")
    private int simulatedWorkLoad;

    public DomainObject findDomainByName(String domainName)
    {
        SimulateWorkload();

        AuthInfo domainAuthInfo = new AuthInfo();
        DomainObject domainObject = new DomainObject();
        domainObject.setAuthInfo(domainAuthInfo);

        return domainObject;
    }

    private void SimulateWorkload() {
        int limit = simulatedWorkLoad; // Define the upper limit for prime numbers calculation
        int primeCount = 0;

        for (int i = 2; i <= limit; i++) {
            if (isPrime(i)) {
                primeCount++;
            }
        }
    }

    // Method to check if a number is prime
    public static boolean isPrime(int number) {
        if (number <= 1) return false;
        if (number == 2 || number == 3) return true;
        if (number % 2 == 0 || number % 3 == 0) return false;

        for (int i = 5; i * i <= number; i += 6) {
            if (number % i == 0 || number % (i + 2) == 0) return false;
        }
        return true;
    }
}
