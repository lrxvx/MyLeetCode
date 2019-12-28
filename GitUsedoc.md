## 1、安装GIt

* linux 安装

  输入git查看是否安装

  下载git Linux版本

  `./config`，`make`，`sudo make install`
  
```
1、安装git依赖包
yum install curl-devel expat-devel gettext-devel openssl-devel zlib-devel gcc perl-ExtUtils-MakeMaker
若已有git先 进行删除。
yum remove git
          
2、上传git安装包到/usr/local/中或者在/usr/local/下执行 wget https://www.kernel.org/pub/software/scm/git/git-2.18.0.tar.gz
解压git安装包
tar -zxvf git-2.18.0.tar.gz
cd git-2.18.0
配置git安装路径
./configure prefix=/usr/local/git/
编译并且安装
make && make install
vi /etc/profile
在PATH那行加上 
/usr/local/git/bin:/usr/local/git/libexec/git-core
让配置立刻生效
source /etc/profile
```
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


#### 3.3 远程仓库

注册GitHub，建立一个库，然后与本地的库做关联

```
 git remote add origin git@github...地址../....git
 git push -u origin master 推送本地库的内容到远程仓库中 第一次 -u参数 会把本地master分支和远程master分支关联起来
 git push origin master 之后需要发送到远程仓库直接这样
 如果有冲突，可能是远程仓库中有文件本地没有，可以在本地创建然后
 git push -f origin master 覆盖
 
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

#### 3.5 Git 命令大全
查看、添加、提交、删除、找回，重置修改文件
```
git help <command> # 显示command的help  
git show # 显示某次提交的内容 git show $id  
git co -- <file> # 抛弃工作区修改  
git co . # 抛弃工作区修改  
git add <file> # 将工作文件修改提交到本地暂存区 
git add . # 将所有修改过的工作文件提交暂存区  
git rm <file> # 从版本库中删除文件  
git rm <file> --cached # 从版本库中删除文件，但不删除文件  
git reset <file> # 从暂存区恢复到工作文件  
git reset -- . # 从暂存区恢复到工作文件  
git reset --hard # 恢复最近一次提交过的状态，即放弃上次提交后的所有本次修改  
git ci <file> git ci . git ci -a # 将git add, git rm和git ci等操作都合并在一起做　　　　　　
git ci -am "some comments"  
git ci --amend # 修改最后一次提交记录  
git revert <$id> # 恢复某次提交的状态，恢复动作本身也创建次提交对象
git revert HEAD # 恢复最后一次提交的状态  
```

查看文件diff
```
git help <command> # 显示command的help  
git show # 显示某次提交的内容 git show $id  
git co -- <file> # 抛弃工作区修改  
git co . # 抛弃工作区修改  
git add <file> # 将工作文件修改提交到本地暂存区 
git add . # 将所有修改过的工作文件提交暂存区  
git rm <file> # 从版本库中删除文件  
git rm <file> --cached # 从版本库中删除文件，但不删除文件  
git reset <file> # 从暂存区恢复到工作文件  
git reset -- . # 从暂存区恢复到工作文件  
git reset --hard # 恢复最近一次提交过的状态，即放弃上次提交后的所有本次修改  
git ci <file> git ci . git ci -a # 将git add, git rm和git ci等操作都合并在一起做　　　　　　　git ci -am "some comments"  
git ci --amend # 修改最后一次提交记录  
git revert <$id> # 恢复某次提交的状态，恢复动作本身也创建次提交对象 
git revert HEAD # 恢复最后一次提交的状态  
```
查看提交记录
```
git log git log <file> # 查看该文件每次提交记录 
git log -p <file> # 查看每次详细修改内容的diff  
git log -p -2 # 查看最近两次详细修改内容的diff  
git log --stat #查看提交统计信息  
tig
Mac上可以使用tig代替diff和log，brew install tig
```
Git 本地分支管理
查看、切换、创建和删除分支

```
git br -r # 查看远程分支  
git br <new_branch> # 创建新的分支  
git br -v # 查看各个分支最后提交信息  
git br --merged # 查看已经被合并到当前分支的分支
git br --no-merged # 查看尚未被合并到当前分支的分支  
git co <branch> # 切换到某个分支  
git co -b <new_branch> # 创建新的分支，并且切换过去  
git co -b <new_branch> <branch> # 基于branch创建新的new_branch  
git co $id # 把某次历史提交记录checkout出来，但无分支信息，切换到其他分支会自动删除  
git co $id -b <new_branch> # 把某次历史提交记录checkout出来，创建成一个分支  
git br -d <branch> # 删除某个分支  
git br -D <branch> # 强制删除某个分支 (未被合并的分支被删除的时候需要强制)  
```

分支合并和reba

```
git merge <branch> # 将branch分支合并到当前分支 
git merge origin/master --no-ff # 不要Fast-Foward合并，这样可以生成merge提交  
git rebase master <branch> # 将master rebase到branch，相当于： git co <branch> && git rebase master && git co master && git merge <branch> 
```
Git补丁管理(方便在多台机器上开发同步时用)
```
git merge <branch> # 将branch分支合并到当前分支 
git merge origin/master --no-ff # 不要Fast-Foward合并，这样可以生成merge提交  
git rebase master <branch> # 将master rebase到branch，相当于： git co <branch> && git rebase master && git co master && git merge <branch>  
```
Git暂存管理
```
git stash # 暂存  
git stash list # 列所有stash  
git stash apply # 恢复暂存的内容  
git stash drop # 删除暂存区  
```
Git远程分支管理
```
git pull # 抓取远程仓库所有分支更新并合并到本地 
git pull --no-ff # 抓取远程仓库所有分支更新并合并到本地，不要快进合并  
git fetch origin # 抓取远程仓库更新  
git merge origin/master # 将远程主分支合并到本地当前分支  
git co --track origin/branch # 跟踪某个远程分支创建相应的本地分支  
git co -b <local_branch> origin/<remote_branch> # 基于远程分支创建本地分支，功能同上  
```

git push # push所有分支
```
git push origin master # 将本地主分支推到远程主分支  
git push -u origin master # 将本地主分支推到远程(如无远程主分支则创建，用于初始化远程仓库)  
git push origin <local_branch> # 创建远程分支， origin是远程仓库名  
git push origin <local_branch>:<remote_branch> # 创建远程分支  
git push origin :<remote_branch> #先删除本地分支(git br -d <branch>)，然后再push删除远程分支 
```

Git远程仓库管理
```
git remote -v # 查看远程服务器地址和仓库名称  
git remote show origin # 查看远程服务器仓库状态 
git remote add origin git@ github:robbin/robbin_site.git # 添加远程仓库地址
git remote set-url origin git@ github.com:robbin/robbin_site.git # 设置远程仓库地址(用于修改远程仓库地址) git remote rm <repository> # 删除远程仓库 
```

创建远程仓库
```
git clone --bare robbin_site robbin_site.git # 用带版本的项目创建纯版本仓库  
scp -r my_project.git git@ git.csdn.net:~ # 将纯仓库上传到服务器上  
mkdir robbin_site.git && cd robbin_site.git && git --bare init # 在服务器创建纯仓库  
git remote add origin git@ github.com:robbin/robbin_site.git # 设置远程仓库地址  
git push -u origin master # 客户端首次提交  
git push -u origin develop # 首次将本地develop分支提交到远程develop分支，并且track  
git remote set-head origin master # 设置远程仓库的HEAD指向master分支 
```

命令设置跟踪远程库和本地库
```
git branch --set-upstream master origin/master  
git branch --set-upstream develop origin/develop
```

