# VirtualAppDemo
使用VirtualApp框架实现微信双开


使用NDK编译VirtualApp native代码时出现的错误：
Error:(81) Android NDK: Application targets deprecated ABI(s): armeabi
Error:(81) Android NDK: Support for these ABIs will be removed in a future NDK release.

解决方法：
在lib/build.gradle中，删除abiFileters中的armeabi
