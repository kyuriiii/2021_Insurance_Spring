package com.insurance.Insurance_spring.domain.contract;
import java.util.ArrayList;

public class ContractListImpl implements ContractList {
	private ArrayList<Contract> contractList;
	public ContractListImpl() {this.setContractList(new ArrayList<Contract>());}
	
	public boolean add(Contract contract) {
		if(this.contractList.add(contract)) return true;
		else return false;
	}
	public boolean delete(int contractID) {
		for(Contract contract: this.contractList) {
			if(contract.getContractID() == contractID) {
				if(this.contractList.remove(contract)) return true;
				break;
			}
		}
		return false;
	}
	public Contract search(int contractID) {
		for(Contract contract : this.contractList) {
			if(contract.getContractID() == contractID) return contract;
		}
		return null;
	}
	public Contract searchByCustomer(int customerID) {
		for(Contract contract : this.contractList) {
			if(contract.getCustomer().getCustomerID() == customerID) return contract;
		}
		return null;
	}
	public ArrayList<Contract> getContractList() {
		return contractList;
	}
	public void setContractList(ArrayList<Contract> contractList) {
		this.contractList = contractList;
	}
}
