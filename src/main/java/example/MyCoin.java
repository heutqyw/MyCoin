/*
Copyright DTCC 2016 All Rights Reserved.

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

         http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
*/

package example;

import com.alibaba.fastjson.JSONObject;
import example.entity.CenterBank;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hyperledger.java.shim.ChaincodeBase;
import org.hyperledger.java.shim.ChaincodeStub;

/**
 数字货币发行与管理
 简介
 该智能合约实现一个简单的商业应用案例，即数字货币的发行与转账。在这之中一共分为三
 种角色：中央银行，商业银行，企业。其中中央银行可以发行一定数量的货币，企业之间可
 以进行相互的转账。主要实现如下的功能：
 初始化中央银行及其发行的货币数量
 新增商业银行，同时央行并向其发行一定数量的货币
 新增企业
 商业银行向企业转给一定数量的数字货币
 企业之间进行相互的转账
 查询企业、银行、交易信息
 */
public class MyCoin extends ChaincodeBase {
	 private static Log log = LogFactory.getLog(MyCoin.class);

	@Override
	public String run(ChaincodeStub stub, String function, String[] args) {
		log.info("In run, function:"+function);
		
		switch (function) {
			//初始化中央银行，并发行一定数量的货币；
			case "init":
				return init(stub, function, args);
			//新增商业银行，同时央行向其发行一定数量的货币；
			case "createBank":
				return createBank(stub, args);
			//新增企业；
			case "createCompany":
				return createCompany(stub, args);
			//央行再次发行一定数量的货币（归于交易行为）；
			case "issueCoin":
				return issueCoin(stub, args);
			//央行向商业银行转一定数量的数字货币（归于交易行为）；
			case "issueCoinToBank":
				return issueCoinToBank(stub, args);
			//商业银行向企业转一定数量的数字货币（归于交易行为）；
			case "issueCoinToCp":
				return issueCoinToCp(stub, args);
			//企业之间进行相互转账（归于交易行为）；
			case "transfer":
				return transfer(stub, args);
			//修改央行信息；
			case "writeCenterBank":
				return writeCenterBank(stub, args);
			//修改商业银行信息；
			case "writeBank":
				return writeBank(stub, args);
			//修改企业信息；
			case "writeCompany":
				return writeCompany(stub, args);
			//写入交易信息。
			case "writeTransaction":
				return writeTransaction(stub, args);
			default:
				return noMethodWarning();
			}
	}

	private String noMethodWarning() {
		return "";
	}

	private String writeTransaction(ChaincodeStub stub, String[] args) {
		return "";
	}

	private String writeCompany(ChaincodeStub stub, String[] args) {
		return "";
	}

	private String writeBank(ChaincodeStub stub, String[] args) {
		return "";
	}

	private String writeCenterBank(ChaincodeStub stub, String[] args) {
		return "";
	}

	private String issueCoinToCp(ChaincodeStub stub, String[] args) {
		return "";
	}

	private String issueCoinToBank(ChaincodeStub stub, String[] args) {
		return "";
	}

	private String issueCoin(ChaincodeStub stub, String[] args) {
		return "";
	}

	private String createCompany(ChaincodeStub stub, String[] args) {
		return "";
	}

	private String createBank(ChaincodeStub stub, String[] args) {
		return "";
	}

	@Override
	public String query(ChaincodeStub stub, String function, String[] args) {
		log.info("In query, function:"+function);

		switch (function) {
			//获取所有的公司信息，如果企业个数大于10，先访问前10个；
			case "getCompanys":
				return getCompanys(stub, args);
			//获取所有的商业银行信息，如果商业银行个数大于10，先访问前 10 个
			case "getBanks":
				return getBanks(stub, args);
			//获取所有的交易记录 如果交易个数大于10，先访问前 10 个；
			case "getTransactions":
				return getTransactions(stub, args);
			//获取某家公司信息；
			case "getCompanyById":
				return getCompanyById(stub, args);
			//获取某家银行信息；
			case "getBankById":
				return getBankById(stub, args);
			//获取某笔交易记录；
			case "getTransactionBy":
				return getTransactionBy(stub, args);
			default:
				return noMethodWarning();
		}
	}

	private String getTransactionBy(ChaincodeStub stub, String[] args) {
		return "";
	}

	private String getBankById(ChaincodeStub stub, String[] args) {
		return "";
	}

	private String getCompanyById(ChaincodeStub stub, String[] args) {
		return "";
	}

	private String getTransactions(ChaincodeStub stub, String[] args) {
		return "";
	}

	private String getBanks(ChaincodeStub stub, String[] args) {
		return "";
	}

	private String getCompanys(ChaincodeStub stub, String[] args) {
		return "";
	}

	private String  transfer(ChaincodeStub stub, String[] args) {
		System.out.println("in transfer");
		if(args.length!=3){
			System.out.println("Incorrect number of arguments:"+args.length);
			return "{\"Error\":\"Incorrect number of arguments. Expecting 3: from, to, amount\"}";
		}
		String fromName =args[0];
		String fromAm=stub.getState(fromName);
		String toName =args[1];
		String toAm=stub.getState(toName);
		String am =args[2];
		int valFrom=0;
		if (fromAm!=null&&!fromAm.isEmpty()){			
			try{
				valFrom = Integer.parseInt(fromAm);
			}catch(NumberFormatException e ){
				System.out.println("{\"Error\":\"Expecting integer value for asset holding of "+fromName+" \"}"+e);		
				return "{\"Error\":\"Expecting integer value for asset holding of "+fromName+" \"}";		
			}		
		}else{
			return "{\"Error\":\"Failed to get state for " +fromName + "\"}";
		}

		int valTo=0;
		if (toAm!=null&&!toAm.isEmpty()){			
			try{
				valTo = Integer.parseInt(toAm);
			}catch(NumberFormatException e ){
				e.printStackTrace();
				return "{\"Error\":\"Expecting integer value for asset holding of "+toName+" \"}";		
			}		
		}else{
			return "{\"Error\":\"Failed to get state for " +toName + "\"}";
		}
		
		int valA =0;
		try{
			valA = Integer.parseInt(am);
		}catch(NumberFormatException e ){
			e.printStackTrace();
			return "{\"Error\":\"Expecting integer value for amount \"}";
		}		
		if(valA>valFrom)
			return "{\"Error\":\"Insufficient asset holding value for requested transfer amount \"}";
		valFrom = valFrom-valA;
		valTo = valTo+valA;
		System.out.println("Transfer "+fromName+">"+toName+" am='"+am+"' new values='"+valFrom+"','"+ valTo+"'");
		stub.putState(fromName,""+ valFrom);
		stub.putState(toName, ""+valTo);		

		System.out.println("Transfer complete");

		return null;
		
	}

	public String init(ChaincodeStub stub, String function, String[] args) {
		if(args.length!=2){
			return "{\"Error\":\"Incorrect number of arguments. Expecting 2\"}";
		}
		try{
			String centerBankName = args[0];
			long totalNumber = Long.parseLong(args[1]);
			CenterBank centerBank=new CenterBank();
			centerBank.setId("0");
			centerBank.setName(centerBankName);
			centerBank.setTotalNumber(totalNumber);
			centerBank.setRestNumber(0);
			String json=JSONObject.toJSONString(centerBank);
			stub.putState(centerBank.getId(), args[1]);
		}catch(NumberFormatException e ){
			return "{\"Error\":\"Expecting long value for args[1]\"}";
		}		
		return null;
	}


	@Override
	public String getChaincodeID() {
		return "MyCoin";
	}

	public static void main(String[] args) throws Exception {
		new MyCoin().start(args);
	}


}
