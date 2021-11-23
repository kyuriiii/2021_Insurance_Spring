package com.insurance.Insurance_spring.library;

import com.insurance.Insurance_spring.domain.customer.Customer;
import com.insurance.Insurance_spring.domain.insurance.Insurance;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Library_UW {
    private int uwRate = 0;

    public void uwRateInit(){
        uwRate = 0;
    }
    public int calcualteFactors(Insurance insurance, Customer customer) {
        int count = 1;
        int finalRate=0;
        int cAccidentCount = customer.getAccident().size();
        switch(insurance.getType()) {
            case "building":
                // 환경적 위험 요소 > 최근 3년 이내에 사고 발생 횟수
                if(cAccidentCount > 0) {
                    if(cAccidentCount == 1) uwRate = 4;
                    else if(cAccidentCount == 2) uwRate = 3;
                    else if(cAccidentCount == 3) uwRate = 2;
                    else uwRate = 1;
                } else uwRate = 0;
                System.out.println("환경 요인: " + uwRate);
                finalRate = uwRate;
                break;
            case "car":
                // 환경적 위험 요소 >  사건/사고 이력
                if(cAccidentCount > 0) {
                    if(cAccidentCount == 1) uwRate += 4;
                    else if(cAccidentCount == 2) uwRate += 3;
                    else if(cAccidentCount == 3) uwRate += 2;
                    else uwRate += 1;
                } else uwRate = 0;
                finalRate += uwRate;
                System.out.println("환경 요인: " + uwRate);
                // 직업별
                if(customer.getM_car().isOwn()==1) {
                    switch(customer.getJob()) {
                        case "학생":
                            if(uwRate != 0) uwRate += 1;
                            break;
                        case "사무직": // 사무직
                            if(uwRate != 0) uwRate += 1;
                            break;
                        case "농부": // 농부
                            if(uwRate > 2) uwRate -= 1;
                            else uwRate = 2;
                            break;
                        case "화물차운전자": // 화물차 운전자
                            if(uwRate > 3) uwRate -= 1;
                            else uwRate = 3;
                            break;
                        case "배달종사자": // 배달 종사자
                            if(uwRate > 3) uwRate -= 1;
                            else uwRate = 3;
                            break;
                        default:
                            break;
                    }
                    count++;
                    finalRate += uwRate;
                }
                System.out.println("직업 요인: " + uwRate);
                break;
            case "driver":
                // 환경적 위험 요소 >  사건/사고 이력
                if(cAccidentCount > 0) {
                    if(cAccidentCount == 1) uwRate += 4;
                    else if(cAccidentCount == 2) uwRate += 3;
                    else if(cAccidentCount == 3) uwRate += 2;
                    else uwRate += 1;
                } else uwRate = 0;

                finalRate += uwRate;
                System.out.println("환경 요인: " + uwRate);
                // 가입 나이
                int joinAge = calcualteCustomerAge(customer);
                if(joinAge >= 20 && joinAge < 30) {
                    if(uwRate == 0 ) {uwRate = 2;}
                    else if(1 < uwRate && uwRate <= 4) {uwRate -= 1;}
                    else { uwRate = 1;}
                } else if(joinAge >= 30 && joinAge < 40) {
                    if(uwRate == 0 ) {uwRate = 4;}
                    else if(1 < uwRate && uwRate <= 4) {uwRate -= 1;}
                    else { uwRate = 1;}
                }
                else if(joinAge >= 40 && joinAge < 50) {
                    if(uwRate == 0 ) {uwRate = 4;}
                    else if(1 < uwRate && uwRate <= 4) {uwRate -= 1;}
                    else { uwRate = 1;}
                }
                else if(joinAge >= 50 && joinAge < 60) {
                    if(uwRate == 0 ) {uwRate = 4;}
                    else if(1 < uwRate && uwRate <= 4) {uwRate -= 1;}
                    else { uwRate = 1;}
                }
                else if(joinAge >= 60) {
                    if(uwRate == 0 ) {uwRate = 3;}
                    else if(1 < uwRate && uwRate <= 4) {uwRate -= 1;}
                    else { uwRate = 1;}
                }
                count++;
                finalRate += uwRate;
                System.out.println("나이 요인: " + uwRate);
                // 운전 여부
                if(customer.getM_car().isOwn() == 1 && uwRate > 1) {
                    switch(customer.getM_car().getCarType()) {
                        case "small": // 승용차
                            if(customer.getM_driver().getCarPurpose() == "personal") uwRate += 0;
                            else if(customer.getM_driver().getCarPurpose() == "official") uwRate -= 1;
                            break;
                        case "van": // 승합차
                            if(customer.getM_driver().getCarPurpose() == "personal") uwRate += 0;
                            else if(customer.getM_driver().getCarPurpose() == "official") uwRate -= 1;
                            break;
                        case "freightCar": // 화물차
                            uwRate -= 1;
                            break;
                        case "motocycle": // 오토바이
                            if(customer.getM_driver().getCarPurpose() == "personal") uwRate += 0;
                            else if(customer.getM_driver().getCarPurpose() == "official") uwRate -= 1;
                            break;
                        case "agricultureCar": // 농업용
                            uwRate -= 1;
                            break;
                        default:
                            break;
                    }
                }
                count++;
                finalRate += uwRate;
                System.out.println("운전 요인: " + uwRate);
                break;
            default: break;
        }
        return (int)finalRate/count;
    }


    private static int calcualteCustomerAge(Customer customer) {
        String[] strArrary = customer.getCustomerNumber().split("");
        int ageYear;
        if(Integer.parseInt(strArrary[0])!=0) ageYear = 1900 + Integer.parseInt(strArrary[0])* 10 + Integer.parseInt(strArrary[1]);
        else ageYear = 2000 + Integer.parseInt(strArrary[1]);
        GregorianCalendar today = new GregorianCalendar();
        int year = today.get(Calendar.YEAR);
        return year - ageYear;
    }
    private static boolean dateCalculate(String accidentDate) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String endDate = df.format(cal.getTime());
        cal.add(Calendar.YEAR, -1);
        String startDate = df.format(cal.getTime());
        LocalDate localDate = LocalDate.parse(accidentDate);
        LocalDate startLocalDate = LocalDate.parse(startDate);
        LocalDate endLocalDate = LocalDate.parse(endDate);
        endLocalDate = endLocalDate.plusDays(1);
        return (! localDate.isBefore(startLocalDate)) && (localDate.isBefore(endLocalDate));
    }
}
