// console.log("hello");
// setTimeout(() => {
//   console.log("Wrold");
// }, 1000);
// console.log(global);
// console.log(globalThis);
// console.log(global === globalThis);

// buffer: 固定长度的内存空间，用来处理一些二进制数据
// 三种创建方式
// alloc
let buf = Buffer.alloc(10); // 这个方法创建的每一个二进制位都会归0
console.log(buf);
//allocUnsafe
let buf_1 = Buffer.allocUnsafe(10); // 此方法，可以能回包含一些旧的内存数据， 因为不会像alloc一样重制为0。 但是它速度比alloc快
console.log(buf_1);
// from
let buf_2 = Buffer.from("hello"); // 每一个字母都会转为unicode，再转为ascii码
console.log(buf_2);

// buffer 与字符串的转换
let buf_3 = Buffer.from([105, 108, 111, 118, 101, 121, 111, 117]);
console.log(buf_3.toString());
