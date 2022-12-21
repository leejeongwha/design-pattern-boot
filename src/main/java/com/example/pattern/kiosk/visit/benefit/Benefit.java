package com.example.pattern.kiosk.visit.benefit;

import com.example.pattern.kiosk.visit.GoldMember;
import com.example.pattern.kiosk.visit.SilverMember;
import com.example.pattern.kiosk.visit.VIPMember;

public interface Benefit {
    void getBenefit(GoldMember member);

    void getBenefit(VIPMember member);

    void getBenefit(SilverMember member);
}
