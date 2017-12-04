function processData(input) {
    let splits = input.split("\n");
    let search = splits[0];
    let N = splits[1];
    let arr = splits[2].split(" ");
    for(let i=0; i<arr.length; ++i){
        if(arr[i] === search){
            console.log(i);
            return;
        }
    }
}

process.stdin.resume();
process.stdin.setEncoding("ascii");
_input = "";
process.stdin.on("data", function (input) {
    _input += input;
});

process.stdin.on("end", function () {
   processData(_input);
});
