## 1、安装GIt

* linux 安装

  输入git查看是否安装

  下载git Linux版本

  `./config`，`make`，`sudo make install`

* window安装

  下载window版本，安装

  ```
  $ git config --global user.name "Your Name"
  $ git config --global user.email "email@example.com"
  ```

## 2、Git初始化

​	git仓库初始化有两种方式：

* 在指定目录下 git init
* 直接从远程仓库中克隆一个仓库下来 git clone ....git
SSH 远程仓库
ssh-keygen -t rsa -C "邮箱"
将~/.ssh/id_rsa.pub中的内容添加在GitHub setting ssh key中

## 3、Git操作命令

#### 3.1 基本提交命令

```
git status 查看仓库状态
git add file 添加文件到暂存区
git add . 添加目录下所有文件
git commit -m "" 提交到本地仓库
git commit -am "" 添加提交，前提是已存在仓库中的文件
git commit --amend  修改备注
```

#### 3.2 历史版本管理

```
git log		查看提交日志，还有很多参数：--pretty=short，--pretty=oneline 加文件名 -p 可以查看文件提交的变化情况，会看到一串字母，commit的版本ID
git log --graph 分支合并图
git diff HEAD -- file	修改后的差异
git rebase -i	压缩提交历史
git checkout file	撤销工作区的代码
git reset HEAD file 可以将暂存区的文件撤销
git checkout -- file  撤销，会将工作区的file的修改全部撤销，回到上一次add或者commit的版本
git reset --hard 加版本号 (回退到指定版本)提交到本地仓库的代码想撤销 HEAD^ 是前一个版本 多少^就是前几个版本 或者HEAD~10
HEAD代表当前版本 HEAD^代表上一个版本 HEAD^^是上上个版本，然后HEAD~10代表上10个版本
git reset --hard 可以加HEAD这种版本号，也可以是具体的commit ID,如果回到了以前的版本，可以通过具体的commit ID回来。
git reflog 用来记住每一次的命令，可以找回以前提交的commit ID，从而回到那个版本

git reset --hard commit_id
HEAD指向的版本就是当前版本，因此，Git允许我们在版本的历史之间穿梭，使用命令git reset --hard commit_id。
穿梭前，用git log可以查看提交历史，以便确定要回退到哪个版本。
要重返未来，用git reflog查看命令历史，以便确定要回到未来的哪个版本。
git rm file 删除，然后 commit 就能删除版本库中的文件了，可以通过 git checkout -- file 撤回到，恢复到最新的版本
```



![1566045268953](C:\Users\a\AppData\Roaming\Typora\typora-user-images\1566045268953.png)



#### 3.3 远程仓库

注册GitHub，建立一个库，然后与本地的库做关联

```
 git remote add origin git@github...地址../....git
 git push -u origin master 推送本地库的内容到远程仓库中 第一次 -u参数 会把本地master分支和远程master分支关联起来
 git push origin master 之后需要发送到远程仓库直接这样
 
 git clone git@github...../....git  直接克隆GitHub的远程仓库
```

#### 3.3 分支管理操作

```
git branch	查看分支
git branch <分支名> 创建
git checkout <分支名>来切换分支
git checkout -b <分支名> 创建加切换
git merge <name> 合并某分支到当前分支	这种是快速合并
git branch -d <name> 删除分支

合并分支的时候可能会出现冲突，这是Git会提醒，然后手动修改master分支上的冲突，add commit
git log --graph --pretty=oneline --abbrev-commit 查看分支合并情况

git merge --no-ff -m "merge with no-ff" dev 表示禁用 快速合并的方式合并分支 这样做就会有合并的历史
```



#### 3.4 标签操作命令

```
轻量级标签
轻量级标签就像是个不会变化的分支，实际上它就是个指向特定提交对象的引用。
git tag v1 tag默认是创建在最新一次的commit
git show <tagname>
删除 git tag -d v1
给具体的某个版本打标签  git tag v0.0 7d519
git push origin v0.0  标签推送到远程仓库 origin是连接远程仓库的别名
```



