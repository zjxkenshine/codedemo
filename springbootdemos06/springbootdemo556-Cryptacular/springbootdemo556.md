# 参考地址
cryptacular 加密库，对Bouncy Castle的补充
- https://github.com/vt-middleware/cryptacular
- https://www.cryptacular.org/

# Cryptacular线程安全的组件
- xxUtil：如CipherUtil, HashUtil
- xxBean：如SimpleHashBean, AEADBlockCipherBean
- generator包：RandomIdGenerator, RBGNonce
- spec包：DigestSpec, BufferedBlockCipherSpec

# 坑
- 官方示例报 java.nio.BufferOverflowException test07

