package com.ait.PaymentKarateTests;

import com.intuit.karate.junit5.Karate;

class PaymentTests {

    @Karate.Test
    Karate testAll() {
        return Karate.run().relativeTo(getClass());
    }
}
