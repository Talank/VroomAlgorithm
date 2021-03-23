const x1 = ['a1','a3','a7'] //driver
const x2 = ['a3','a7','a8','a9'] //customer

console.log(updateFenceDirection(x1,x2))
//updateFenceDirection(x2,x1)


function updateFenceDirection(customerFences, driverFences){

  let i = 0;
  
  //check from where the fence path of customer starts in driver
  //check what fence data are not in driver but in customer ==> customer - driver
  for (var i = driverFences.indexOf(customerFences[0]); i< driverFences.length ; i++) {
  	if(customerFences[i - driverFences.indexOf(customerFences[0])] != undefined){
  		break;
  	}
  }
  
  
  //add the customer- driver data on the driver at last 
  //now we have the index of customerFences from which data to driver has to be added

  i = i - driverFences.indexOf(customerFences[0]);

  while(i < customerFences.length){
  	driverFences.push(customerFences[i])
  	i++;
  }
}