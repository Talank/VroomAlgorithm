import helper from '../api/helper';

function getFencePath(data){
	let path= [];
	for(var i=0; i< data.length; i++) {
		fence = helper.getFence(data[i].latitude, data[i].longitude,response.data);

		//checking if the consecutive last fence is the same fence or not! 
		if(path[path.length-1] != fence){
			path.push(fence);
			console.log(fence);
		}
	}
	return path;
}