const x1 = ['a1','a3','a7','a9','a10'] //driver
const x2 = ['a7','a9','a10','a11'] //customer

//console.log(updateFenceDirection(x2,x1))
updateFenceDirection(x2,x1)


function updateFenceDirection(customerFences, driverFences){  
  //check if there is extra fence path in the customerFences
  //if customerFences is perfectly subset of driverFence, then return driverfence directly
  //else append extra path into driverFences
  if(checkIfSubset(customerFences, driverFences)){
    console.log(driverFences)
    return driverFences
  }
   
  //find the index of last element of customer on the driver
  let i = customerFences.indexOf(driverFences[driverFences.length -1]) + 1;
  while(i < customerFences.length){
    driverFences.push(customerFences[i])
    i++;
  }
  console.log(driverFences)
  return driverFences
}

function checkIfSubset(customerFences, driverFences){
    if(driverFences.length > driverFences.indexOf(customerFences[0]) + customerFences.length){
      console.log(driverFences.length + " is greater than " +driverFences.indexOf(customerFences[0]))
      return true
    }
    else{
      console.log("false")
      return false
    }
}