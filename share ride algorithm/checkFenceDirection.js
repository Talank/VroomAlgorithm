const x1 = ['a0','a1', 'a2', 'a3','a4','a5'] //driver
const x2 = ['a1','a2', 'a3','a4'] //customer

checkFenceDirection(x2,x1)


function checkFenceDirection(customerFences, driverFences){
	//search from customer's first index on driver to driver's last index or customer last index whichever comes first 
	//(because if customer comes first then the value is undefined)
  	for (var i = driverFences.indexOf(customerFences[0]); i< driverFences.length ; i++) {

  		//if the fence path element in a particular index is not same 
  		// && customer fence data still eexists in the index we are checking for then, return false 
  		if((customerFences[i - driverFences.indexOf(customerFences[0])] != undefined) &&
          (driverFences[i] != customerFences[i - driverFences.indexOf(customerFences[0])])){
  			//console.log("not ok")
  			return false
  		}	
  	}
  	//console.log("ok")
  	return true
}