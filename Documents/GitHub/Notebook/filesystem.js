//  创建一个名为：message.txt   内容： good good study, day day up
// step
// 导入fs 模块: file system
const fs = require("fs");
// 写入文件
data = "good good study, day day up";
fs.writeFile("message.txt", data, (err) => {
  // err: 写入失败，抛出异常
  if (err) throw err;
  console.log("1: The file has been saved!");
});
console.log(1 + 1);

// fs的两种模式： 同步 && 异步
// writeFile是异步操作， writeFileSync是同步操作
// fs.writeFileSync("message1.txt", data);
try {
  fs.writeFileSync("message1.txt", data);
  console.log("2: The file has been saved!");
} catch (err) {
  throw err;
}
console.log(1 + 2);

/**
 * 上面的运行结果如下，writefilesync 会等到写完之后再运行下面的代码
2
2: The file has been saved!
3
1: The file has been saved!
 */

// fs的追加写入 appendFile,  appendFileSync, 或者直接用writefile来完成
data1 = "\r\nIt is a nice day!";
fs.appendFile("message.txt", data1, (err) => {
  if (err) {
    throw err;
  }
  console.log("Done!");
});
// 需要持续的追加的情况，经常使用以下的方法吗，如日志
fs.writeFile("message1.txt", data1, { flag: "a" }, (err) => {
  if (err) throw err;
  console.log("Done again");
});

// 还有一种创建写入流的文件写入方法createWriteStream
const fs1 = fs.createWriteStream("message2.txt");
fs1.write("one\r\n");
fs1.write("two\r\n");
fs1.write("three\r\n");
fs1.write("four\r\n");
fs1.close();
