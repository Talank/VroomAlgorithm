const x1 = ['a1','a3','a7'] //driver
const x2 = ['a3','a7','a8','a9','a7'] //customer

//console.log(updateFenceDirection(x2,x1))
updateFenceDirection(x2,x1)


function updateFenceDirection(customerFences, driverFences){  
  //check if there is extra fence path in the customerFences
  //if customerFences is perfectly subset of driverFence, then return driverfence directly
  //else append extra path into driverFences
  
   
  //find the index of last element of customer on the driver
  let i = customerFences.indexOf(driverFences[driverFences.length -1]) + 1;
  while(i < customerFences.length){
    driverFences.push(customerFences[i])
    i++;
  }
  //console.log(driverFences)
  return driverFences
}