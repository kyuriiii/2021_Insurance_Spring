//package com.insurance.Insurance_spring;
//
//
//import com.insurance.Insurance_spring.domain.accident.Accident;
//import com.insurance.Insurance_spring.domain.accident.AccidentList;
//import com.insurance.Insurance_spring.domain.contract.Contract;
//import com.insurance.Insurance_spring.domain.contract.ContractList;
//import com.insurance.Insurance_spring.domain.customer.*;
//import com.insurance.Insurance_spring.domain.dao.*;
//import com.insurance.Insurance_spring.domain.employee.Employee;
//import com.insurance.Insurance_spring.domain.employee.EmployeeList;
//import com.insurance.Insurance_spring.domain.exemption.Exemption;
//import com.insurance.Insurance_spring.domain.insurance.*;
//import com.insurance.Insurance_spring.domain.pCustomer.PCustomer;
//import com.insurance.Insurance_spring.domain.pCustomer.PCustomerList;
//import com.insurance.Insurance_spring.domain.reward.RewardInfo;
//
//import java.text.DateFormat;
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.time.LocalDate;
//import java.util.*;
//
//public class IMain {
//	private static Employee employee;
//	private static InsuranceList insuranceList;
//	private static CustomerList customerList;
//	private static PCustomerList pCustomerList;
//	private static AccidentList accidentList;
//	private static EmployeeList employeeList;
//	private static ContractList contractList;
//
//	// dao
//	private static AccidentDao accidentDao;
//	private static ContractDao contractDao;
//	private static CustomerDao customerDao;
//	private static BuildingDao buildingDao;
//	private static CarDao carDao;
//	private static DriverDao driverDao;
//	private static InsuranceDao insuranceDao;
//	private static SaleRecordDao saleRecordDao;
//	private static CoverageDao coverageDao;
//	private static ApproveDao approveDao;
//	private static PCustomerDao pCustomerDao;
//	private static ExemptionDao exemptionDao;
//	private static DamageDao damageDao;
//	private static EmployeeDao employeeDao;
//
//	private static int uwRate;
//	private static Scanner sc;
//	private static boolean dataflag; // dataflag는 면/부책 판단에서 디비에서 잘못된 값이 있는지 확인용.
//
//	public IMain() {
//		sc = new Scanner(System.in);
//		uwRate = 0;
//		dataflag = false;
//
//		accidentDao = new AccidentDaoImpl();
//		contractDao = new ContractDaoImpl();
//		customerDao = new CustomerDaoImpl();
//		buildingDao = new BuildingDaoImpl();
//		carDao = new CarDaoImpl();
//		driverDao = new DriverDaoImpl();
//		insuranceDao = new InsuranceDaoImpl();
//		saleRecordDao = new SaleRecordDaoImpl();
//		coverageDao = new CoverageDaoImpl();
//		approveDao = new ApproveDaoImpl();
//		pCustomerDao = new PCustomerDaoImpl();
//		exemptionDao = new ExemptionDaoImpl();
//		damageDao = new DamageDaoImpl();
//		employeeDao = new EmployeeDaoImpl();
//	}
//
//	public static void setDBData() {
//		pCustomerList = pCustomerDao.retrieve();
//		customerList = customerDao.retrieve();
//		insuranceList = insuranceDao.retrieve();
//		accidentList = accidentDao.retrieve();
//		contractList = contractDao.retrieve();
//		employeeList = employeeDao.retrieve();
//	}
//	public static void main(String[] args) {
//		IMain main = new IMain();
//		boolean flag = false;
//		setDBData();
//		System.out.println("직원 아이디를 입력하세요. ");
//		employee = employeeList.search(Integer.parseInt(sc.nextLine()));
//		while ( employee == null ) {
//			System.out.println("존재하지 않는 직원 ID를 입력하셨습니다. 다시 입력해주세요.");
//			employee = employeeList.search(Integer.parseInt(sc.nextLine()));
//		}
//		int menu = checkEmployee(employee);
//		for(int i =0; i<6; i++) {
//			switch(menu) {
//				case 1:
//					// 보험 설계
//					System.out.println("*******보험설계 메뉴 ********");
//					System.out.println("1. 설계하기");
//					System.out.println("2. 상품 인가하기");
//					System.out.println("3. 사후 관리하기");
//					System.out.println("4. 종료하기");
//
//					int submenu =Integer.parseInt(sc.nextLine());
//					switch(submenu) {
//						case 1:
//							insuranceDesign();
//							break;
//						case 2:
//							System.out.println("***********보험상품을 인가하는 페이지입니다**************");
//							insuranceApprove();
//							break;
//						case 3:
//							System.out.println("***********보험상품을 사후관리하는 페이지입니다**************");
//							insuranceManage();
//							break;
//						case 4: System.out.println("프로그램을 종료합니다.");
//							flag = true;
//							break;
//					}
//					break;
//
//				case 2:
//					// UW
//					System.out.println("******* UW 메뉴 ********");
//					System.out.println("1. 인수심사하기");
//					System.out.println("2. 종료하기");
//					switch(Integer.parseInt(sc.nextLine())) {
//						case 2: System.out.println("프로그램을 종료합니다.");
//							flag = true;
//							break;
//					}
//					break;
//				case 3:
//					// 영업
//					System.out.println("*******영업 메뉴 ********");
//					System.out.println("1. 상담하기");
//					System.out.println("2. 계약체결");
//					System.out.println("3. 계약관리");
//					System.out.println("4. 고객관리");
//					System.out.println("5. 종료하기");
//
//					switch(Integer.parseInt(sc.nextLine())) {
//						case 1: consult(); break;
//						case 2: contract(0); break;
//						case 3: contractManage(); break;
//						case 4: customerManage(); break;
//						case 5: System.out.println("프로그램을 종료합니다.");
//							flag = true;
//							break;
//					}
//					break;
//				case 4:
//					// 보상
//					System.out.println("*******보상 메뉴 ********");
//					System.out.println("1. 고객정보확인");
//					System.out.println("2. 사고접수");
//					System.out.println("3. 사고현장조사하기");
//					System.out.println("4. 면/부책 판단하기");
//					System.out.println("5. 손해 사정하기");
//					System.out.println("6. 종료하기");
//
//					switch(Integer.parseInt(sc.nextLine())) {
//						case 1: checkcustomerInfo(); break;
//						case 2: acceptAccident(null); break;
//						case 3: investigate(); break;
//						case 4: decideExemption(); break;
//						case 5: damageAssessment(); break;
//						case 6: System.out.println("프로그램을 종료합니다.");
//							flag = true;
//							break;
//					}
//					break;
//				default:
//					System.out.println("데이터가 올바르지 않습니다. 다시 입력해주세요.");
//					break;
//			}
//			if(flag == true) break;
//		}
//	}
//	private static void insuranceDesign() {
//		Insurance insurance = new Insurance();
//
//		System.out.println("보험 설계를 시작합니다.");
//
//		System.out.println("설계하고자 하는 보험상품 유형을 선택해주세요.");
//		System.out.println("1. 자동차 화재보험");
//		System.out.println("2. 건물 화재보험");
//		System.out.println("3. 운전자 보험");
//
//		switch ( Integer.parseInt(sc.nextLine()) ) {
//			case 1: insurance.setInsuranceType("car"); break;
//			case 2: insurance.setInsuranceType("building"); break;
//			case 3: insurance.setInsuranceType("driver"); break;
//		}
//
//		System.out.println("보험명을 입력해주세요.");
//		insurance.setInsuranceName(sc.nextLine());
//
//		System.out.println("보험 설명을 입력해주세요.");
//		insurance.setContents(sc.nextLine());
//
//		System.out.println("보험 기본 가입비를 입력해주세요.");
//		insurance.setInsuranceCost(sc.nextLine());
//
//		int insuranceID = insuranceDao.create(insurance);
//		if ( insuranceID == 0 ) return; // 0이라는 것은 무언가 잘못되었다는 거!
//
//		insurance.setInsuranceID(insuranceID);
//
//		Coverage hcoverage = new Coverage();
//		hcoverage.setCoverageCondition("high");
//		System.out.println("사고위험 정도가 높은 경우의 보장내용을 입력해주세요.");
//		hcoverage.setCoverageContent(sc.nextLine());
//		System.out.println("사고위험 정도가 높은 경우의 최대보장금액을 입력해주세요.");
//		hcoverage.setCoverageCost(Integer.parseInt(sc.nextLine()));
//		hcoverage.setInsuranceID(insuranceID);
//		int hcoverageID = coverageDao.create(hcoverage);
//		hcoverage.setCoverageID(hcoverageID);
//		insurance.setM_hcoverage(hcoverage);
//
//		Coverage mcoverage = new Coverage();
//		mcoverage.setCoverageCondition("middle");
//		System.out.println("사고위험 정도가 중간일 경우의 보장내용을 입력해주세요.");
//		mcoverage.setCoverageContent(sc.nextLine());
//		System.out.println("사고위험 정도가 중간일 경우의 최대보장금액을 입력해주세요.");
//		mcoverage.setCoverageCost(Integer.parseInt(sc.nextLine()));
//		mcoverage.setInsuranceID(insuranceID);
//		int mcoverageID = coverageDao.create(mcoverage);
//		mcoverage.setCoverageID(mcoverageID);
//		insurance.setM_mcoverage(mcoverage);
//
//		Coverage lcoverage = new Coverage();
//		lcoverage.setCoverageCondition("low");
//		System.out.println("사고위험 정도가 낮은 경우의 보장내용을 입력해주세요.");
//		lcoverage.setCoverageContent(sc.nextLine());
//		System.out.println("사고위험 정도가 낮은 경우의 최대보장금액을 입력해주세요.");
//		lcoverage.setCoverageCost(Integer.parseInt(sc.nextLine()));
//		lcoverage.setInsuranceID(insuranceID);
//		int lcoverageID = coverageDao.create(lcoverage);
//		lcoverage.setCoverageID(lcoverageID);
//		insurance.setM_lcoverage(lcoverage);
//
//		insuranceList.add(insurance);
//		System.out.println("보험 설계가 완료되었습니다.");
//	}
//
//	private static void insuranceApprove() {
//		// 인가가 진행되지 않은 보험 목록 가져오기
//		ArrayList<Insurance> insurances = insuranceDao.retrieveNoApprove().getInsuranceList();
//
//		System.out.println("***** 보험 목록 *****");
//		for ( Insurance insurance : insurances ) { System.out.println( insurance.getInsuranceID()+" "+insurance.getInsuranceName());}
//
//		System.out.println("상품 인가를 진행할 보험 ID를 입력하세요.");
//		Insurance insurance = insuranceList.search(Integer.parseInt(sc.nextLine()));
//		while ( insurance == null ) {
//			System.out.println("존재하지 않는 보험ID를 입력하셨습니다. 다시 입력해주세요.");
//			insurance = insuranceList.search(Integer.parseInt(sc.nextLine()));
//		}
//
//		System.out.println("***** 보험정보 *****");
//		System.out.println("보험 ID : " + insurance.getInsuranceID());
//		System.out.println("보험명 : " + insurance.getInsuranceName());
//		System.out.println("보험유형 : " + insurance.getInsuranceType());
//		System.out.println("보험 기본 가입비 : " + insurance.getInsuranceCost());
//		System.out.println("보험내용 : " + insurance.getContents());
//		System.out.println("상 - 보장내용 : " + insurance.getM_hcoverage().getCoverageContent());
//		System.out.println("상 - 최대보장금액 : " + insurance.getM_hcoverage().getCoverageCost());
//		System.out.println("중 - 보장내용 : " + insurance.getM_mcoverage().getCoverageContent());
//		System.out.println("중 - 최대보장금액 : " + insurance.getM_mcoverage().getCoverageCost());
//		System.out.println("하 - 보장내용 : " + insurance.getM_lcoverage().getCoverageContent());
//		System.out.println("하 - 최대보장금액 : " + insurance.getM_lcoverage().getCoverageCost());
//
//		System.out.println("상품인가를 승인하시려면 1을, 거절하시려면 2를, 대기하시려면 3을 입력해주세요");
//
//		SimpleDateFormat format = new SimpleDateFormat ( "yyyy-MM-dd");
//		Date time = new Date();
//		Approve approve = new Approve();
//
//		switch(Integer.parseInt(sc.nextLine())) {
//			case 1 :
//				approve.setInsuranceID(insurance.getInsuranceID());
//				approve.setApproved(1);
//				approve.setPermissionDate(format.format(time));
//				System.out.println(format.format(time) + "에 " + insurance.getInsuranceName() + "보험이 인가 승인되었습니다." );
//				insurance.setM_approve(approve);
//				insuranceList.delete(insurance.getInsuranceID());
//				approveDao.create(approve);
//
//				break;
//			case 2 :
//				System.out.println("상품 인가를 거절하셨습니다.");
//				approve.setInsuranceID(insurance.getInsuranceID());
//				approve.setApproved(0);
//				approve.setPermissionDate(format.format(time));
//				System.out.println("거절 사유를 입력해주세요.");
//				approve.setPermissionRefuse(sc.nextLine());
//				System.out.println("보험의 문제점을 입력해주세요.");
//				approve.setInsuranceProblem(sc.nextLine());
//				System.out.println(format.format(time) + "에 " + insurance.getInsuranceName() + "보험 인가를 거부하셨습니다." );
//				insurance.setM_approve(approve);
//				insuranceList.delete(insurance.getInsuranceID());
//				approveDao.create(approve);
//				break;
//			case 3 :
//				System.out.println("대기중인 상태입니다.");
//				break;
//		}
//	}
//
//	private static void insuranceManage() {
//		System.out.println("********** 보험 목록 ************");
//		ArrayList<Insurance> insurances = insuranceDao.retrieveApprove().getInsuranceList();
//		for ( Insurance insurance : insurances ) { System.out.println( insurance.getInsuranceID()+" "+insurance.getInsuranceName());}
//
//		System.out.println("판매실적표를 작성할 보험 ID를 입력하세요.");
//		Insurance insurance = insuranceList.search(Integer.parseInt(sc.nextLine()));
//		while ( insurance == null ) {
//			System.out.println("존재하지 않는 보험 ID를 입력하셨습니다. 다시 입력해주세요.");
//			insurance = insuranceList.search(Integer.parseInt(sc.nextLine()));
//		}
//
//		System.out.println("***** 보험정보 *****");
//		System.out.println("보험 ID : " + insurance.getInsuranceID());
//		System.out.println("보험명 : " + insurance.getInsuranceName());
//		System.out.println("보험유형 : " + insurance.getInsuranceType());
//		System.out.println("보험 기본 가입비 : " + insurance.getInsuranceCost());
//		System.out.println("보험내용 : " + insurance.getContents());
//		System.out.println("상 - 보장내용 : " + insurance.getM_hcoverage().getCoverageContent());
//		System.out.println("상 - 최대보장금액 : " + insurance.getM_hcoverage().getCoverageCost());
//		System.out.println("중 - 보장내용 : " + insurance.getM_mcoverage().getCoverageContent());
//		System.out.println("중 - 최대보장금액 : " + insurance.getM_mcoverage().getCoverageCost());
//		System.out.println("하 - 보장내용 : " + insurance.getM_lcoverage().getCoverageContent());
//		System.out.println("하 - 최대보장금액 : " + insurance.getM_lcoverage().getCoverageCost());
//
//		System.out.println("판매실적표를 작성하시려면 1을, 취소하시려면 2를, 대기하시려면 3을 입력해주세요.");
//
//		switch ( Integer.parseInt(sc.nextLine()) ) {
//			case 1:
//				if ( insurance.getM_SaleRecord().getInsuranceID() != 0 ) {
//					System.out.println("판매실적표가 이미 기록되어 있습니다.");
//
//					System.out.println("*********판매실적표*********");
//					System.out.println("목표 개수 : " + insurance.getM_SaleRecord().getGoalCnt());
//					System.out.println("달성 개수 : " + insurance.getM_SaleRecord().getSaleCnt());
//					System.out.println("달성율 : " + ( (double)insurance.getM_SaleRecord().getSaleCnt() / (double)insurance.getM_SaleRecord().getGoalCnt() ) * 100);
//				}
//				else {
//					SaleRecord saleRecord = new SaleRecord();
//					System.out.println("해당 보험의 목표 개수를 입력하십시오.");
//					saleRecord.setGoalCnt(Integer.parseInt(sc.nextLine()));
//					System.out.println("해당 보험의 판매 개수를 입력하십시오.");
//					saleRecord.setSaleCnt(Integer.parseInt(sc.nextLine()));
//
//					System.out.println("입력하신 판매실적표의 내용은 아래와 같습니다. 맞으시면 1을, 틀리면 2를 입력해주십시오.");
//					System.out.println("*********판매실적표*********");
//					System.out.println("목표 개수 : " + saleRecord.getGoalCnt());
//					System.out.println("달성 개수 : " + saleRecord.getSaleCnt());
//					System.out.println("달성율 : " + ( (double)saleRecord.getSaleCnt() / (double)saleRecord.getGoalCnt() ) * 100);
//
//					if ( Integer.parseInt(sc.nextLine() ) == 1 ) {
//						saleRecord.setInsuranceID(insurance.getInsuranceID());
//						saleRecordDao.create(saleRecord);
//						insurance.setM_SaleRecord(saleRecord);
//						System.out.println("판매실적표 작성이 완료되었습니다.");
//					}
//				}
//				break;
//
//			case 2: System.out.println("판매실적표 작성이 취소되었습니다."); break;
//			case 3: break;
//		}
//	}
//	private static int checkEmployee(Employee employee) {
//		String number = String.valueOf(employee.getEmployeeID());
//		char[] nums = number.toCharArray();
//		if(nums[0] == '1') {
//			System.out.println("사원번호 : " + employee.getEmployeeID() + " 사원명: " + employee.getName());
//			return 1;
//		} else if(nums[0] == '2') {
//			System.out.println("사원번호 : " + employee.getEmployeeID() + " 사원명: " + employee.getName());
//			return 2;
//		} else if(nums[0] == '3') {
//			System.out.println("사원번호 : " + employee.getEmployeeID() + " 사원명: " + employee.getName());
//			return 3;
//		} else if(nums[0] == '4') {
//			System.out.println("사원번호 : " + employee.getEmployeeID() + " 사원명: " + employee.getName());
//			return 4;
//		}
//		return 0;
//	}
//	// U/W
//	private static int calcualteFactors(Insurance insurance, Customer customer) {
//		int count = 1;
//		int finalRate=0;
//		int cAccidentCount = customer.getAccident().size();
//		switch(insurance.getInsuranceType()) {
//			case "building":
//				// 환경적 위험 요소 > 최근 3년 이내에 사고 발생 횟수
//				if(cAccidentCount > 0) {
//					if(cAccidentCount == 1) uwRate = 4;
//					else if(cAccidentCount == 2) uwRate = 3;
//					else if(cAccidentCount == 3) uwRate = 2;
//					else uwRate = 1;
//				} else uwRate = 0;
//				System.out.println("환경 요인: " + uwRate);
//				finalRate = uwRate;
//				break;
//			case "car":
//				// 환경적 위험 요소 >  사건/사고 이력
//				if(cAccidentCount > 0) {
//					if(cAccidentCount == 1) uwRate += 4;
//					else if(cAccidentCount == 2) uwRate += 3;
//					else if(cAccidentCount == 3) uwRate += 2;
//					else uwRate += 1;
//				} else uwRate = 0;
//				finalRate += uwRate;
//				System.out.println("환경 요인: " + uwRate);
//				// 직업별
//				if(customer.getM_car().isOwn()==1) {
//					switch(customer.getJob()) {
//						case "학생":
//							if(uwRate != 0) uwRate += 1;
//							break;
//						case "사무직": // 사무직
//							if(uwRate != 0) uwRate += 1;
//							break;
//						case "농부": // 농부
//							if(uwRate > 2) uwRate -= 1;
//							else uwRate = 2;
//							break;
//						case "화물차운전자": // 화물차 운전자
//							if(uwRate > 3) uwRate -= 1;
//							else uwRate = 3;
//							break;
//						case "배달종사자": // 배달 종사자
//							if(uwRate > 3) uwRate -= 1;
//							else uwRate = 3;
//							break;
//						default:
//							break;
//					}
//					count++;
//					finalRate += uwRate;
//				}
//				System.out.println("직업 요인: " + uwRate);
//				break;
//			case "driver":
//				// 환경적 위험 요소 >  사건/사고 이력
//				if(cAccidentCount > 0) {
//					if(cAccidentCount == 1) uwRate += 4;
//					else if(cAccidentCount == 2) uwRate += 3;
//					else if(cAccidentCount == 3) uwRate += 2;
//					else uwRate += 1;
//				} else uwRate = 0;
//
//				finalRate += uwRate;
//				System.out.println("환경 요인: " + uwRate);
//				// 가입 나이
//				int joinAge = calcualteCustomerAge(customer);
//				if(joinAge >= 20 && joinAge < 30) {
//					if(uwRate == 0 ) {uwRate = 2;}
//					else if(1 < uwRate && uwRate <= 4) {uwRate -= 1;}
//					else { uwRate = 1;}
//				} else if(joinAge >= 30 && joinAge < 40) {
//					if(uwRate == 0 ) {uwRate = 4;}
//					else if(1 < uwRate && uwRate <= 4) {uwRate -= 1;}
//					else { uwRate = 1;}
//				}
//				else if(joinAge >= 40 && joinAge < 50) {
//					if(uwRate == 0 ) {uwRate = 4;}
//					else if(1 < uwRate && uwRate <= 4) {uwRate -= 1;}
//					else { uwRate = 1;}
//				}
//				else if(joinAge >= 50 && joinAge < 60) {
//					if(uwRate == 0 ) {uwRate = 4;}
//					else if(1 < uwRate && uwRate <= 4) {uwRate -= 1;}
//					else { uwRate = 1;}
//				}
//				else if(joinAge >= 60) {
//					if(uwRate == 0 ) {uwRate = 3;}
//					else if(1 < uwRate && uwRate <= 4) {uwRate -= 1;}
//					else { uwRate = 1;}
//				}
//				count++;
//				finalRate += uwRate;
//				System.out.println("나이 요인: " + uwRate);
//				// 운전 여부
//				if(customer.getM_car().isOwn() == 1 && uwRate > 1) {
//					switch(customer.getM_car().getCarType()) {
//						case "small": // 승용차
//							if(customer.getM_driver().getCarPurpose() == "personal") uwRate += 0;
//							else if(customer.getM_driver().getCarPurpose() == "official") uwRate -= 1;
//							break;
//						case "van": // 승합차
//							if(customer.getM_driver().getCarPurpose() == "personal") uwRate += 0;
//							else if(customer.getM_driver().getCarPurpose() == "official") uwRate -= 1;
//							break;
//						case "freightCar": // 화물차
//							uwRate -= 1;
//							break;
//						case "motocycle": // 오토바이
//							if(customer.getM_driver().getCarPurpose() == "personal") uwRate += 0;
//							else if(customer.getM_driver().getCarPurpose() == "official") uwRate -= 1;
//							break;
//						case "agricultureCar": // 농업용
//							uwRate -= 1;
//							break;
//						default:
//							break;
//					}
//				}
//				count++;
//				finalRate += uwRate;
//				System.out.println("운전 요인: " + uwRate);
//				break;
//			default: break;
//		}
//		return (int)finalRate/count;
//	}
//	// 영업
//	private static void consult() {
//		System.out.println("****** 상담 대기 예비 고객 리스트 ******");
//		ArrayList<PCustomer> pCustomers = pCustomerList.getCustomerList();
//		for ( PCustomer pCustomer : pCustomers ) { System.out.println( pCustomer.getPCustomerID() + " " + pCustomer.getCustomerName() + " " + pCustomer.getPhoneNumber() + " " + pCustomer.getDate() ); }
//
//		System.out.println("상담하고자 하는 고객의 ID를 입력하세요.");
//
//		PCustomer pCustomer = pCustomerList.search(Integer.parseInt(sc.nextLine()));
//		while ( pCustomer == null ) {
//			System.out.println("존재하지 않는 예비고객 ID를 입력하셨습니다. 다시 입력해주세요.");
//			pCustomer = pCustomerList.search(Integer.parseInt(sc.nextLine()));
//		}
//		pCustomerList.delete(pCustomer.getPCustomerID());
//
//		Customer customer = new Customer();
//		customer.setPCustomerID(pCustomer.getPCustomerID());
//		customer.setCustomerName(pCustomer.getCustomerName());
//		customer.setPhoneNumber(pCustomer.getPhoneNumber());
//		customer.setDate(pCustomer.getDate());
//
//		System.out.println("***** 선택한 고객의 데이터 *****");
//		System.out.println("예비고객 ID : " + customer.getPCustomerID());
//		System.out.println("이름 : " + customer.getCustomerName());
//		System.out.println("전화번호 : " + customer.getPhoneNumber());
//		System.out.println("상담신청날짜 : " + customer.getDate());
//
//		System.out.println("***** 상담 내용 입력 ******");
//		System.out.println("주소를 입력하세요.");
//		customer.setAddress(sc.nextLine());
//		System.out.println("주민번호를 입력하세요.(- 제외)");
//		customer.setCustomerNumber(sc.nextLine());
//		System.out.println("성별을 입력하세요. 여/남");
//		customer.setSex(sc.nextLine());
//		System.out.println("직업을 입력하세요.");
//		customer.setJob(sc.nextLine());
//		System.out.println("이메일 주소를 입력하세요.");
//		customer.seteMail(sc.nextLine());
//		System.out.println("상담 내용을 입력하세요.");
//		String context = sc.nextLine();
//		customer.setConsultContext(context);
//
//		pCustomer.setConsultContext(context);
//		pCustomerDao.updateID(pCustomer.getPCustomerID(), pCustomer);
//
//		int customerID = customerDao.create(customer);
//		customer.setCustomerID( customerID );
//		customerList.add(customer);
//
//		System.out.println("상담 완료");
//	}
//	private static void contract( int ID ) {
//		System.out.println("****** 계약 체결 전 고객 리스트 ******");
//		ArrayList<Customer> customers = customerList.getCustomerList();
//		for ( Customer customer : customers ) { System.out.println( customer.getCustomerID()+" "+customer.getDate()+" "+customer.getCustomerName() );}
//
//		Customer customer;
//		if ( ID == 0 ) {
//			System.out.println("계약을 체결할 고객의 ID를 입력하세요.");
//
//			customer = customerList.search(Integer.parseInt(sc.nextLine()));
//			while ( customer == null ) {
//				System.out.println("존재하지 않는 고객ID를 입력하셨습니다. 다시 입력해주세요.");
//				customer = customerList.search(Integer.parseInt(sc.nextLine()));
//			}
//		}
//		else customer = customerList.search(ID);
//
//		System.out.println("***** 고객의 신상 정보 *****");
//		System.out.println("고객 ID : " + customer.getCustomerID());
//		System.out.println("이름 : " + customer.getCustomerName());
//		System.out.println("주소 : " + customer.getAddress());
//		System.out.println("주민번호 : " + customer.getCustomerNumber());
//		System.out.println("성별 : " + customer.getSex());
//		System.out.println("직업 : " + customer.getJob());
//		System.out.println("***** 상담 내용 *****");
//		System.out.println("상담날짜 : " + customer.getDate());
//		System.out.println("상담내용 : " + customer.getConsultContext() + "\n");
//		// 상담원 직원 이름 필요.
//
//		System.out.println("***** 보험 목록 *****");
//		ArrayList<Insurance> insurances = insuranceDao.retrieveApprove().getInsuranceList();
//		for ( Insurance insurance : insurances ) { System.out.println( insurance.getInsuranceID()+" "+insurance.getInsuranceName());}
//
//		System.out.println("계약을 체결할 보험의 ID를 입력하세요.");
//		Insurance insurance = insuranceList.search(Integer.parseInt(sc.nextLine()));
//		while ( insurance == null ) {
//			System.out.println("존재하지 않는 보험ID를 입력하셨습니다. 다시 입력해주세요.");
//			insurance = insuranceList.search(Integer.parseInt(sc.nextLine()));
//		}
//
//		// 고객 정보 입력
//		Customer ccustomer = contractCustomer(insurance, customer);
//		System.out.println("인수심사를 시작합니다.");
//		int uwRate = calcualteFactors(insurance, ccustomer); // 인수심사하는 함수
//
//		if ( uwRate == 1 ) {
//			System.out.println("인수심사 결과 계약을 체결할 수 없습니다. 초기화면으로 돌아갑니다.");
//			return;
//		}
//		else System.out.println("인수심사 결과 계약을 체결할 수 있는 고객입니다. 요율계산을 시작합니다.");
//
//		SimpleDateFormat format = new SimpleDateFormat ( "yyyy-MM-dd");
//		Date time = new Date();
//
//		Contract contract = new Contract();
//		contract.setCustomer(ccustomer);
//		contract.setInsurance(insurance);
//		contract.setDate(format.format(time));
//
//		float insuranceRatio = contract.calculateRatio();
//		int finalPrice = 0;
//		if ( insuranceRatio != 0 ) finalPrice = (int) ( Integer.parseInt(insurance.getInsuranceCost()) * insuranceRatio );
//		else finalPrice = Integer.parseInt(insurance.getInsuranceCost());
//
//		System.out.println("책정된 고객 가입보험료는 " + finalPrice + "입니다.");
//		System.out.println("계약을 진행하시려면 1, 계약을 중도 중료하시려면 2를 눌러주세요.");
//
//		if ( Integer.parseInt( sc.nextLine() ) == 2 ) return;
//
//		contract.setPrice(finalPrice);
//		System.out.println("만기일을 입력하세요. ( 0000-00-00 )");
//		contract.setEndDate(sc.nextLine());
//
//		int contractID = contractDao.create(contract);
//		contract.setContractID(contractID);
//		contractList.add(contract);
//
//		System.out.println("계약이 체결되었습니다.");
//	}
//	private static Customer contractCustomer(Insurance insurance, Customer customer) {
//		System.out.println("고객의 사고정보 입력을 시작합니다.");
//		int accidentNum;
//		String txtLine,buildingLine,carLine,driverLine;
//
//		switch ( insurance.getInsuranceType()) {
//			case "building":
//				System.out.println("고객의 3년 이내 건물화재 사고전적이 있으면 사고 전적 횟수를 입력해주세요. 없으면 0을 입력해주세요.");
//				accidentNum = Integer.parseInt(sc.nextLine());
//
//				for( int i = 0; i<accidentNum; i++ ) {
//					System.out.println("건물화재 날짜/시간/장소/사고사이즈(high,middle,high)를 입력해주세요. ");
//					System.out.println("ex) 2021-05-23/18:30/서울시 은평구/high");
//					txtLine = sc.nextLine();
//					Accident accident = new Accident();
//
//					String[] txtSplit = txtLine.split("/");
//					accident.setCustomer(customer);
//					accident.setAccidentType("building");
//					accident.setAccidentDate(txtSplit[0]);
//					accident.setAccidentTime(txtSplit[1]);
//					accident.setAccidentPlace(txtSplit[2]);
//					accident.setAccidentSize(txtSplit[3]);
//					accident.setAccidentComplete(0);
//
//					int accidentID = accidentDao.create(accident);
//					accident.setAccidentID(accidentID);
//					customer.setAccident(accident);
//					accidentList.add(accident);
//				}
//				Building building = new Building();
//				System.out.println("사고의 건물정보 입력을 시작합니다.");
//				System.out.println("사고가 일어난 건물의 건축연도/건물높이(m기준)/건물가격/건물면적/건물외벽(seramic,zinc,stone)를 입력해주세요. ");
//				buildingLine = sc.nextLine();
//				if ( !buildingLine.equals("") ) {
//					String[] buildingSplit = buildingLine.split("/");
//					building.setYear(Integer.parseInt(buildingSplit[0]));
//					building.setBuildingHeight(Integer.parseInt(buildingSplit[1]));
//					building.setBuildingPrice(buildingSplit[2]);
//					building.setBuildingSize(Integer.parseInt(buildingSplit[3]));
//					building.setBuildingOutwall(buildingSplit[4]);
//
//					buildingDao.create(building, customer.getCustomerID());
//					customer.setM_building(building);
//				}
//				break;
//
//			case "car":
//				System.out.println("고객의 5년 이내 자동차화재 사고전적이 있으면 사고 전적 횟수를 입력해주세요. 없으면 0을 입력해주세요.");
//				accidentNum = Integer.parseInt(sc.nextLine());
//
//				for( int i = 0; i<accidentNum; i++ ) {
//					System.out.println("자동차화재 날짜/시간/장소/사고사이즈(high,middle,low)를 입력해주세요. ");
//					System.out.println("ex) 2021-05-23/18:30/서울시 은평구/high");
//					txtLine = sc.nextLine();
//					Accident accident = new Accident();
//
//					String[] txtSplit = txtLine.split("/");
//					accident.setCustomer(customer);
//					accident.setAccidentDate(txtSplit[0]);
//					accident.setAccidentType("car");
//					accident.setAccidentTime(txtSplit[1]);
//					accident.setAccidentPlace(txtSplit[2]);
//					accident.setAccidentSize(txtSplit[3]);
//					accident.setAccidentComplete(0);
//
//					int accidentID = accidentDao.create(accident);
//					accident.setAccidentID(accidentID);
//					customer.setAccident(accident);
//					accidentList.add(accident);
//				}
//
//				System.out.println("고객의 자동차정보 입력을 시작합니다.");
//				System.out.println("자동차의 자동차번호/소유여부(유,무)/자동차종류(small,van,freightCar,motocycle,agricultureCar)을 입력해주세요. ");
//				carLine = sc.nextLine();
//				if ( !carLine.equals("") ) {
//					Car car = new Car();
//					String[] carSplit = carLine.split("/");
//					car.setCarNum(carSplit[0]);
//					if ( carSplit[1].equals("유") ) car.setOwn(1);
//					else car.setOwn(0);
//
//					car.setCarType(carSplit[2]);
//					carDao.create(car, customer.getCustomerID());
//					customer.setM_car(car);
//				}
//				break;
//
//			case "driver":
//				System.out.println("고객의 2년 이내 자동차 사고전적이 있으면 사고 전적 횟수를 입력해주세요. 없으면 0을 입력해주세요.");
//				accidentNum = Integer.parseInt(sc.nextLine());
//
//				for( int i = 0; i<accidentNum; i++ ) {
//					System.out.println("자동차 사고 날짜/시간/장소/사고사이즈(high,middle,low)를 입력해주세요. ");
//					System.out.println("ex)2021-05-23/18:30/서울시 은평구/high");
//					txtLine = sc.nextLine();
//					Accident accident = new Accident();
//
//					String[] txtSplit = txtLine.split("/");
//					accident.setCustomer(customer);
//					accident.setAccidentType("driver");
//					accident.setAccidentDate(txtSplit[0]);
//					accident.setAccidentTime(txtSplit[1]);
//					accident.setAccidentPlace(txtSplit[2]);
//					accident.setAccidentSize(txtSplit[3]);
//					accident.setAccidentComplete(0);
//
//					int accidentID = accidentDao.create(accident);
//					accident.setAccidentID(accidentID);
//					customer.setAccident(accident);
//					accidentList.add(accident);
//				}
//
//				System.out.println("고객의 자동차정보 입력을 시작합니다.");
//				System.out.println("자동차의 자동차번호/소유여부(유,무)/자동차종류(small,van,freightCar,motocycle,agricultureCar)을 입력해주세요. ");
//				carLine = sc.nextLine();
//				if ( !carLine.equals("") ) {
//					Car car = new Car();
//					String[] carSplit = carLine.split("/");
//					car.setCarNum(carSplit[0]);
//					if ( carSplit[1].equals("유") ) car.setOwn(1);
//					else car.setOwn(0);
//
//					car.setCarType(carSplit[2]);
//					carDao.create(car, customer.getCustomerID());
//					customer.setM_car(car);
//				}
//
//				System.out.println("고객의 운전자 정보 입력을 시작합니다.");
//				System.out.println("고객의 운전자면허번호/차량소유목적(personal/official)을 입력해주세요. ");
//				driverLine = sc.nextLine();
//				if ( !driverLine.equals("") ) {
//					Driver driver = new Driver();
//					String[] driverSplit = driverLine.split("/");
//					driver.setLicenseNum(driverSplit[0]);
//					driver.setCarPurpose(driverSplit[1]);
//
//					driverDao.create(driver, customer.getCustomerID());
//					customer.setM_driver(driver);
//				}
//				break;
//		}
//		return customer;
//	}
//
//	private static void contractManage() {
//		System.out.println("****** 계약 리스트 ******");
//		ArrayList<Contract> contracts = contractList.getContractList();
//		for ( Contract contract : contracts ) { System.out.println(contract.getDate()+" "+contract.getContractID()+" "+contract.getCustomer().getCustomerName()+" "+contract.getInsurance().getInsuranceName()); }
//
//		System.out.println("관리할 계약의 ID를 입력하세요.");
//
//		Contract contract = contractList.search(Integer.parseInt(sc.nextLine()));
//		if ( contract == null ) {
//			System.out.println("없는 계약ID를 입력하셨습니다. 다시 입력해주세요.");
//			contract = contractList.search(Integer.parseInt(sc.nextLine()));
//		}
//
//		System.out.println("***** 계약 정보 *****");
//		System.out.println("계약날짜 : " + contract.getDate());
//		System.out.println("보험명 : " + contract.getInsurance().getInsuranceName());
//		System.out.println("고객명 : " + contract.getCustomer().getCustomerName());
//		System.out.println("고객 전화번호 : " + contract.getCustomer().getPhoneNumber());
//		System.out.println("납입보험료 : " + contract.getPrice());
//		System.out.println("만기일 : " + contract.getEndDate() + "\n");
//
//		System.out.println("관리할 메뉴를 입력해주세요.");
//		System.out.println("1.계약연장 2.신규상품체결 3.종료");
//
//		switch(Integer.parseInt(sc.nextLine())) {
//			case 1:
//				System.out.println("1.1년연장 2.2년연장 3.3년연장 4.취소");
//				int num = Integer.parseInt(sc.nextLine());
//				while ( num > 4 ) {
//					System.out.println( "잘못 입력하셨습니다. 다시 메뉴를 입력해주세요." );
//					num = Integer.parseInt(sc.nextLine());
//				}
//				if ( num == 4 ) return;
//
//				String newEndDate = contract.getEndDate();
//
//				try {
//					SimpleDateFormat dtFormat = new SimpleDateFormat("yyyy-MM-dd");
//					Calendar cal = Calendar.getInstance();
//
//					Date dt = dtFormat.parse(contract.getEndDate());
//					cal.setTime(dt);
//					cal.add(Calendar.YEAR, num);
//
//					newEndDate =  dtFormat.format(cal.getTime());
//				} catch (ParseException e) {
//					e.printStackTrace();
//				}
//
//				System.out.println("계약 만기일을 "+contract.getEndDate()+"에서 "+newEndDate+"로 연장합니다.");
//
//				contract.setEndDate(newEndDate);
//
//				contractDao.updateID(contract.getContractID(), contract);
//				contractList.delete(contract.getContractID());
//				contractList.add(contract);
//				break;
//
//			case 2: contract(contract.getCustomer().getCustomerID()); break;
//		}
//	}
//	private static void customerManage() {
//		System.out.println("****** 계약 리스트 ******");
//		ArrayList<Contract> contracts = contractList.getContractList();
//		for ( Contract contract : contracts ) { System.out.println(contract.getContractID()+" "+contract.getCustomer().getCustomerName()+" "+contract.getInsurance().getInsuranceName()); }
//
//		System.out.println("관리할 고객의 계약 ID를 입력하세요.");
//
//		Contract contract = contractList.search(Integer.parseInt(sc.nextLine()));
//		if ( contract == null ) {
//			System.out.println("없는 계약ID를 입력하셨습니다. 다시 입력해주세요.");
//			contract = contractList.search(Integer.parseInt(sc.nextLine()));
//		}
//
//		System.out.println("***** 계약 정보 *****");
//		System.out.println("계약날짜 : " + contract.getDate());
//		System.out.println("보험명 : " + contract.getInsurance().getInsuranceName());
//		System.out.println("고객명 : " + contract.getCustomer().getCustomerName());
//		System.out.println("고객 전화번호 : " + contract.getCustomer().getPhoneNumber());
//		System.out.println("직업 : " + contract.getCustomer().getJob());
//		System.out.println("주소 : " + contract.getCustomer().getAddress());
//		System.out.println("주민번호 : " + contract.getCustomer().getCustomerNumber());
//		System.out.println("납입보험료 : " + contract.getPrice());
//		System.out.println("보상금 지급 횟수 : " + accidentDao.retrieveAccidentCnt(contract.getCustomer().getCustomerID()));
//
//		System.out.println("만기일 : " + contract.getEndDate() + "\n");
//
//		System.out.println("메뉴를 선택해주세요.");
//		// 블랙리스트 등록은 납부 DB를 따로 받지 않기 때문에 없앴습니다.
//		System.out.println("1.고객정보수정 3.종료");
//
//		switch ( Integer.parseInt(sc.nextLine()) ) {
//			case 1:
//				System.out.println("***** 고객 정보 변경을 시작합니다. *****");
//				System.out.println("변경할 고객 이름을 입력해주세요.");
//				String newName = sc.nextLine();
//				if ( newName != "" ) contract.getCustomer().setCustomerName(newName);
//				System.out.println("변경할 고객 전화번호을 입력해주세요.");
//				String newPhone = sc.nextLine();
//				if ( newPhone != "" ) contract.getCustomer().setPhoneNumber(newPhone);
//				System.out.println("변경할 고객 직업을 입력해주세요.");
//				String newJob = sc.nextLine();
//				if ( newJob != "" ) contract.getCustomer().setJob(newJob);
//				System.out.println("변경할 고객 주소를 입력해주세요.");
//				String newAddress = sc.nextLine();
//				if ( newAddress != "" ) contract.getCustomer().setAddress(newAddress);
//
//				contractDao.updateIDCustomer(contract);
//				contractList.delete(contract.getContractID());
//				contractList.add(contract);
//				System.out.println("고객 정보 변경이 완료되었습니다. 초기 화면으로 돌아갑니다.");
//
//				break;
//
//			case 3:
//				break;
//		}
//	}
//	// 보상
//	private static void checkcustomerInfo() {
//		// 고객 정보 확인하기
//		System.out.println("***** 고객정보를 입력해주세요. *****");
//		Customer customer = new Customer();
//		System.out.println("이름 : ");
//		customer.setCustomerName(sc.nextLine());
//		System.out.println("주민번호(-제외) : ");
//		customer.setCustomerNumber(sc.nextLine());
//
//		if(customer.getCustomerName() != null && customer.getCustomerNumber() != null) { // 대안흐름 1
//			System.out.println("***** 입력된 고객의 정보입니다*****");
//			System.out.println("이름 : " + customer.getCustomerName() + "\n" + "주민번호 : " + customer.getCustomerNumber());
//			System.out.println("고객의 정보를 확인하시겠습니까? 확인하시려면 1을, 취소하시려면 2를 눌러주세요.");
//
//			switch ( Integer.parseInt(sc.nextLine())) {
//				case 1:
//					Customer bcustomer = customerList.search(customer);
//					if( bcustomer != null) { // 고객리스트에 존재
//						System.out.println("ID : " + bcustomer.getCustomerID() + "\n" +
//								"이름 : " + bcustomer.getCustomerName() + "\n"
//								+ "주민번호 : " + bcustomer.getCustomerNumber() + "\n" +
//								"성별 : " + bcustomer.getSex() + "\n"
//								+ "전화번호: " + bcustomer.getPhoneNumber());
//
//						System.out.println("해당 고객의 보험 가입 여부를 확인합니다.");
//
//						Contract contract = contractList.searchByCustomer( bcustomer.getCustomerID() );
//						if ( contract == null ) {
//							System.out.println("보험 계약이 되어 있지 않은 고객은 사고 접수가 불가능합니다.");
//
//							return;
//						}
//						else {
//							System.out.println("고객의 계약정보를 확인합니다.");
//
//							System.out.println("***** 계약 정보 *****");
//							System.out.println("계약날짜 : " + contract.getDate());
//							System.out.println("보험명 : " + contract.getInsurance().getInsuranceName());
//							System.out.println("고객명 : " + contract.getCustomer().getCustomerName());
//							System.out.println("고객 전화번호 : " + contract.getCustomer().getPhoneNumber());
//							System.out.println("직업 : " + contract.getCustomer().getJob());
//							System.out.println("주소 : " + contract.getCustomer().getAddress());
//							System.out.println("주민번호 : " + contract.getCustomer().getCustomerNumber());
//							System.out.println("납입보험료 : " + contract.getPrice());
//							System.out.println("보상금 지급 횟수 : " + accidentDao.retrieveAccidentCnt(contract.getCustomer().getCustomerID()));
//
//							System.out.println("만기일 : " + contract.getEndDate() + "\n");
//
//							System.out.println("사고 접수를 계속 진행하시려면 1을, 취소하시려면 2를 입력해주세요.");
//							if ( Integer.parseInt(sc.nextLine()) == 2 ) return;
//						}
//						System.out.println("사고를 접수하는 페이지로 이동합니다");
//						acceptAccident(bcustomer);
//					} else {System.out.println("없는 고객 정보입니다. 보상 메뉴 처음으로 돌아갑니다.");}
//					break;
//
//				case 2:
//					System.out.println("취소하셨습니다. 초기 메뉴로 돌아갑니다.");
//					break;
//			}
//		}
//		else System.out.println("미입력된 값이 존재합니다. 초기 메뉴로 돌아갑니다.");
//	}
//	private static void acceptAccident(Customer bcustomer) {// 사고 접수
//		Accident accident = new Accident();
//		if(bcustomer == null) {
//			System.out.println("----------- 사고 접수하는 고객을 먼저 확인해주세요. 고객 정보 확인 메뉴로 이동합니다. ------------------");
//			checkcustomerInfo(); // 고객정보확인
//		} else {
//			accident.setCustomer(bcustomer);
//			System.out.println();
//			System.out.println("***** 사고정보를 입력해주세요. *****");
//			System.out.println("사고 날짜(yyyy-mm-dd)를 입력해주세요.");
//			accident.setAccidentDate(sc.nextLine());
//			if(accident.getAccidentDate().length() != 10) { // 대안 흐름 2
//				System.out.println("정해진 양식에 맞게 입력하셔야 합니다. 사고 날짜(yyyy-mm-dd)");
//				accident.setAccidentDate(sc.nextLine());
//			}
//			if(dateCalculate(accident.getAccidentDate())) { // 대안 흐름 1
//				System.out.println("사고 시간을 입력해주세요.");
//				accident.setAccidentTime(sc.nextLine());
//				System.out.println("사고 장소를 입력해주세요.");
//				accident.setAccidentPlace(sc.nextLine());
//				System.out.println("사고 유형(building, car, driver)을 입력해주세요.");
//				accident.setAccidentType(sc.nextLine());
//				System.out.println("사고 단계(상, 중, 하)를 입력해주세요.");
//				accident.setAccidentSize(sc.nextLine());
//				if(accident.getAccidentDate() != "" && accident.getAccidentTime() != ""
//						&& accident.getAccidentPlace() != "" && accident.getAccidentType() != null && accident.getAccidentSize() !=null) {
//					System.out.println("사고 날짜: " + accident.getAccidentDate() + "\n"
//							+ "사고 시간: " + accident.getAccidentTime() + "\n" +
//							"사고 장소 : " + accident.getAccidentPlace() + "\n"
//							+ "사고 유형: " + accident.getAccidentType() + "\n" +
//							"사고단계 : " + accident.getAccidentSize());
//					System.out.println("사고 접수를 진행합니다. 1.네 2. 아니요");
//					int flagNum = Integer.parseInt(sc.nextLine());
//					if(flagNum == 1) {
//						int accidentID = accidentDao.create(accident);
//						accident.setAccidentID(accidentID);
//						accident.setAccidentComplete(1); // 사고 미처리
//						accident.setJudgementComplete(1); // 면부책 미처리
//						SimpleDateFormat format = new SimpleDateFormat ( "yyyy-MM-dd");
//						Date time = new Date();
//						accident.setDate(format.format(time));
//						accidentDao.createInfo(accident);
//						accidentList.add(accident);
//						System.out.println("사고 접수가 완료되었습니다.");
//					} else if(flagNum == 2) { // 대안 흐름 4
//						System.out.println("사고 접수를 취소하셨습니다.");
//					}
//				} else { // 대안 흐름 3
//					System.out.println("미입력된 값이 존재합니다. 보상 메뉴 처음으로 돌아갑니다.");
//				}
//			} else System.out.println("1년 넘게 지난 사건은 보험을 접수할 수 없습니다. 보상 메뉴 처음으로 돌아갑니다.");
//		}
//	}
//	private static void investigate() { // 사고현장조사하기
//		System.out.println("작업할 일의 번호를 입력하세요. 1.사고처리하기 2.사고접수 직접하기");
//		int flagNum = Integer.parseInt(sc.nextLine());
//		if(flagNum == 1) { addAccidentInfo(); 	}
//		else if(flagNum == 2) { // 대안흐름
//			checkcustomerInfo();
//			addAccidentInfo();
//		}
//	}
//	private static void addAccidentInfo() {
//		System.out.println("**** 접수된 사고 리스트 ****");
//		ArrayList<Accident> accidents = accidentDao.retrieveNotcompleted().getAccidentList();
//		if(accidents.size() != 0) { // 사고가 모두 처리되었을 경우
//			for(Accident sAccident : accidents) {
//				System.out.println("사고 번호: " + sAccident.getAccidentID() + "\n" +
//						"사고 날짜: " + sAccident.getAccidentDate() + "\n"
//						+ "사고 시간: " + sAccident.getAccidentTime() + "\n" +
//						"사고 장소 : " + sAccident.getAccidentPlace() + "\n"
//						+ "사고 유형: " + sAccident.getAccidentType() + "\n" +
//						"사고단계 : " + sAccident.getAccidentSize() + "\n" );
//				System.out.println("---------------------------------------");
//			}
//			System.out.println("처리할 사고의 ID를 입력하세요."); // 기본흐름
//			Accident daccident = accidentList.search(Integer.parseInt(sc.nextLine()));
//			while ( daccident == null ) {
//				System.out.println("존재하지 않는 사고 ID를 입력하셨습니다. 다시 입력해주세요.");
//				daccident = accidentList.search(Integer.parseInt(sc.nextLine()));
//			}
//			System.out.println("사고 번호: " + daccident.getAccidentID() + "\n" +
//					"사고 날짜 : " + daccident.getAccidentDate() + "\n"
//					+ "사고 시간: " + daccident.getAccidentTime() + "\n" +
//					"사고 장소 : " + daccident.getAccidentPlace() + "\n"
//					+ "사고 유형: " + daccident.getAccidentType() + "\n" +
//					"사고단계 : " + daccident.getAccidentSize() + "\n" );
//			System.out.println("******** 현장 정보를 추가해주세요. ************");
//			System.out.println("사건 시나리오를 입력하세요.");
//			daccident.getM_siteInfo().setScenario(sc.nextLine());
//
//			System.out.println("사건 녹취록 파일이 있으면 1, 없으면 2를 입력하세요.");
//			daccident.getM_siteInfo().setRecord(Integer.parseInt(sc.nextLine()));
//
//			System.out.println("영상이 있으면 1, 없으면 2를 입력하세요.");
//			daccident.getM_siteInfo().setVideo(Integer.parseInt(sc.nextLine()));
//
//			System.out.println("사진이 있으면 1, 없으면 2를 입력하세요.");
//			daccident.getM_siteInfo().setPhoto(Integer.parseInt(sc.nextLine()));
//
//			System.out.println("피해 규모(상, 중, 하)를 입력하세요.");
//			daccident.getM_siteInfo().setDamageScale(sc.nextLine());
//
//			System.out.println("해당 사건을 시스템에 등록하시려면 1을 입력하세요.");
//			if(Integer.parseInt(sc.nextLine()) == 1) {
//				daccident.setAccidentComplete(0); // 사고 처리
//				accidentDao.createInvestigation(daccident);
//				accidentDao.update(daccident);
//			}
//		} else System.out.println("처리할 사고가 없습니다.");
//	}
//	private static void decideExemption() {
//		// 면/부책 판단하기
//		System.out.println("******* 면/부책 리스트 ********");
//		ArrayList<Accident> accidents = accidentDao.retrievecommpleted().getAccidentList();
//		if( accidents != null ) {
//			for(Accident accident : accidents) {
//				System.out.println("사고 번호: " + accident.getAccidentID() + "\n" +
//						"사고 접수 날짜 : " + accident.getDate() + "\n" +
//						"사고 단계 : " + accident.getAccidentSize() + "\n" +
//						"심사여부 ( 0 심사, 1 미심사) : " + accident.getJudgementComplete());
//				System.out.println("------------------------------------");
//				if(accident.getDate() == "" || accident.getAccidentSize() == null ) { // 예외흐름 1
//					System.out.println("해당 정보에 문제가 있어 심사할 수 없습니다. 보상 메뉴 초기로 돌아갑니다.");
//					dataflag = true;
//				}
//			}
//		}
//		if(!dataflag) { // 예외흐름 flag
//			System.out.println(" 면/부책 심사할 사고의 ID를 입력하세요.");
//			Accident accident =  accidentList.search(Integer.parseInt(sc.nextLine()));
//			System.out.println("-------------------------------------");
//			System.out.println("사고 번호: " + accident.getAccidentID() + "\n" +
//					"사고 날짜 : " + accident.getAccidentDate() + "\n" +
//					"사고 장소 : " + accident.getAccidentPlace() + "\n"
//					+ "사고 유형 : " + accident.getAccidentType() + "\n" +
//					"사고 단계 (상, 중, 하) : " + accident.getAccidentSize() + "\n" +
//					"사건 시나리오 : " + accident.getM_siteInfo().getScenario() + "\n" +
//					"사건 녹취록(1 있음, 2 없음): " + accident.getM_siteInfo().getRecord() + "\n" +
//					"영상(1 있음, 2 없음): " + accident.getM_siteInfo().getVideo() + "\n" +
//					"사진(1 있음, 2 없음): " + accident.getM_siteInfo().getPhoto() + "\n" +
//					"피해규모(상, 중, 하) : " + accident.getM_siteInfo().getDamageScale());
//			System.out.println("-------------------------------------");
//			System.out.println("면/부책 정보를 입력해주세요.");
//			Exemption exemption = new Exemption();  // 면/부책 용 데이터
//			System.out.println("면/부책 여부(승인, 거절)를 입력하세요.");
//			String isaccepted = sc.nextLine();
//			if(isaccepted.equals("승인")) {accident.setJudgementComplete(0);}
//			else if(isaccepted.equals("불허")) {accident.setJudgementComplete(1);}
//			System.out.println("판단 이유를 작성하세요.");
//			exemption.setReason(sc.nextLine());
//			System.out.println("참고 자료가 있나요? 있으면 1, 없으면 2를 입력하세요.");
//			exemption.setSubFile(Integer.parseInt(sc.nextLine()));
//			System.out.println("관련 법규 내용을 입력하세요.");
//			exemption.setLegacy( sc.nextLine());
//			if( exemption.getReason() != "" && exemption.getSubFile() != 0 && exemption.getLegacy() != "") { // 대안 흐름 1
//				exemption.setAccidentID(accident.getAccidentID()); // 사고 ID 저장
//				exemptionDao.create(exemption);
//				accidentDao.updateJudged(accident);
//				System.out.println("해당 사건의 면/부책 심사가 완료되었습니다.");
//			} else {
//				System.out.println("미입력된 정보가 존재합니다. 보상 메뉴 초기로 돌아갑니다.");
//			}
//		}
//	}
//	private static void damageAssessment() {
//		System.out.println("**********손해사정 대기리스트*********");
//		ArrayList<Exemption> damageassessmentList = exemptionDao.retrieveList().getExemptionList(); // 승인된 리스트만
//		for(Exemption sAccident : damageassessmentList) {
//			System.out.println("사고 번호 : "+ sAccident.getAccidentID());
//			System.out.println("사고발생 날짜 : "+ sAccident.getAccidentDate());
//			System.out.println("------------------------------------");
//		}
//		System.out.println("손해를 사정할 사고의 ID를 입력하세요");
//		Exemption exemption = exemptionDao.retrieveList().search(Integer.parseInt(sc.nextLine()));
//		System.out.println("-------------------------------------");
//		System.out.println("사고 번호: " + exemption.getAccidentID() + "\n" +
//				"판단 이유: " + exemption.getReason() + "\n" +
//				"참고 자료( 1 있음, 2 없음) : " + exemption.getSubFile() + "\n" +
//				"관련 법규: " + exemption.getLegacy() + "\n" +
//				"고객 번호: " + exemption.getCustomerID());
//		System.out.println("-------------------------------------");
//		System.out.println("손해사정 정보를 입력하겠습니다.");
//		RewardInfo rewardInfo = new RewardInfo();
//		rewardInfo.setEmployee(employee);;
//		System.out.println("지급 금액을 입력해주세요");
//		rewardInfo.setPayment(sc.nextLine());
//		System.out.println("판단 이유를 작성해주세요");
//		rewardInfo.setAssessReason(sc.nextLine());
//		Customer customer = customerList.search(exemption.getCustomerID());
//		System.out.println();
//		System.out.println(customer.getCustomerName() + "님께 "+ "손해사정 결과 보상금으로 " +rewardInfo.getPayment() + "원을 지급합니다.");
//		rewardInfo.setAccident(exemption);
//		damageDao.create(rewardInfo); //손해사정 정보 디비에 저장
//		accidentList.delete(exemption.getAccidentID());
//	}
//	private static int calcualteCustomerAge(Customer customer) {
//		String[] strArrary = customer.getCustomerNumber().split("");
//		int ageYear;
//		if(Integer.parseInt(strArrary[0])!=0) ageYear = 1900 + Integer.parseInt(strArrary[0])* 10 + Integer.parseInt(strArrary[1]);
//		else ageYear = 2000 + Integer.parseInt(strArrary[1]);
//		GregorianCalendar today = new GregorianCalendar();
//		int year = today.get(Calendar.YEAR);
//		return year - ageYear;
//	}
//	private static boolean dateCalculate(String accidentDate) {
//		Calendar cal = Calendar.getInstance();
//		cal.setTime(new Date());
//		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
//		String endDate = df.format(cal.getTime());
//		cal.add(Calendar.YEAR, -1);
//		String startDate = df.format(cal.getTime());
//		LocalDate localDate = LocalDate.parse(accidentDate);
//		LocalDate startLocalDate = LocalDate.parse(startDate);
//		LocalDate endLocalDate = LocalDate.parse(endDate);
//		endLocalDate = endLocalDate.plusDays(1);
//		return (! localDate.isBefore(startLocalDate)) && (localDate.isBefore(endLocalDate));
//	}
//}