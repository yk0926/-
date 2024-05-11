package com.kyong.interview.ODTest;


public class ODTestCSDN {
    //1 最大化控制资源成本
    /*public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int taskNum = sc.nextInt();
        int[][] task = new int[taskNum][3];
        for(int i=0;i<taskNum; i++){
            task[i][0] = sc.nextInt();
            task[i][1] = sc.nextInt();
            task[i][2] = sc.nextInt();
        }
        //按开始时间排序
        int res = 0;
        int tempRes = 0;
        Arrays.sort(task,(a,b)->(a[0]-b[0]));
        PriorityQueue<Integer[]> priorityQueue = new PriorityQueue<>((a,b)->a[0]-b[0]);
        for (int i = 0; i < taskNum; i++) {
            while (priorityQueue.size()>0){
                Integer[] cur = priorityQueue.peek();
                if(task[i][0]>cur[0]){
                    Integer[] poll = priorityQueue.poll();
                    tempRes -= poll[1];
                }else {
                    break;
                }
            }
            priorityQueue.offer(new Integer[]{task[i][1],task[i][2]});
            tempRes += task[i][2];
            if(tempRes>res){
                res = tempRes;
            }

        }
        System.out.println(res);
    }*/

    //2 租车骑绿岛
    /*    public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int maxWeight = sc.nextInt();
            int num = sc.nextInt();
            sc.nextLine();
            String input = sc.nextLine();
            String[] s = input.split(" ");
            Integer[] people = new Integer[s.length];
            for(int i = 0; i<s.length ;i++){
                people[i] = Integer.parseInt(s[i]);
            }
            Arrays.sort(people);
            int low = 0;
            int high = people.length-1;
            int res = 0;
            while (low<high){
                if(maxWeight >= people[low]+people[high]){
                    low++;
                    high--;
                    res++;
                }else {
                    res++;
                    high--;
                }
            }
            if(low==high){
                res++;
            }
            System.out.println(res);
        }*/

    /*3 几何平均值最大子数组*/
    /*    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int N = sc.nextInt();
    int L = sc.nextInt();
    Double[] a = new Double[N];
    for (int i=0;i<N;i++){
        a[i] = sc.nextDouble();
    }
    Double res = 0.0;
    int start = 0;
    int length = L;
    for (int i = 0; i <= a.length-L; i++) {
        for (int j =i+L-1;j<a.length;j++){
            Double[] range = Arrays.copyOfRange(a, i, j+1);
            Double kAverage = KAverage(range);
            if(res< kAverage){
                res = kAverage;
                start = j;
                length = range.length;
            };
        }
    }
    System.out.println(start+" "+ length);

    }
    static Double KAverage(Double[] a){
    Double res = 1.000000000;
    for (int i = 0; i < a.length; i++) {
        res *= a[i];
    }
    return Math.pow(res,1.0/(a.length));

    }*/


    /*4 农村施肥*/
    /*    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        Integer[] fields = new Integer[m];
        for (int i = 0; i < m; i++) {
            fields[i]=sc.nextInt();
        }
        if(m>n){
            System.out.println("-1");
            return;
        }
        Arrays.sort(fields);
        if(m == n){
            System.out.println(fields[fields.length-1]);
            return;
        }
        int left = 0;
        int right = fields[fields.length-1];
        int res = -1;
        int tempRes = 0;

        while (left+1<right){
            int k = (int) Math.ceil((double)(left + right) / 2);
            tempRes = needDays(k, fields);
            if(tempRes == n){
                System.out.println(k);
                return;
            }
            if(tempRes>n){
                //需要的天数大于n
                left = k;
            }else {
                //需要的天数小于n
                right = k;
                res = k;
            }
        }
        System.out.println(res);



    }
    static Integer needDays(Integer k, Integer[] fields){
        int res = 0;
        for (int i = 0; i < fields.length; i++) {
            if(fields[i]<k){
                res++;
            }else {
                res+= Math.ceil((double)fields[i] / (1.0*k));
            }
        }
        return res;
    }*/

    //5 组装新的数组 [回溯！]
    /*    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] sArr = s.split(" ");
        Integer[] arr = new Integer[sArr.length];
        int M = sc.nextInt();
        for (int i = 0; i < sArr.length; i++) {
            arr[i] = Integer.parseInt(sArr[i]);
        }
        Arrays.sort(arr);
        Integer minNum = arr[0];
        System.out.println(dfs(arr,0,0,minNum,M,0));

    }

    static Integer dfs(Integer[] arr, int index, int sum, int minNum, int M, int count){
        if(sum>M){
            return count;
        }
        if(sum == M || ((M-sum)<minNum)){
            return count+1;
        }
        for(int i = index; i<arr.length;i++){
            count = dfs(arr,i,sum+arr[i],minNum,M,count);
        }
        return count;
    }*/

    //6 快速开租建站
    /*public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int taskNum = sc.nextInt();
        int relationsNum = sc.nextInt();
        Integer[][] relation = new Integer[relationsNum][2];
        for (int i = 0; i < relationsNum; i++){
            relation[i][0] = sc.nextInt();
            relation[i][1] = sc.nextInt();
        }
        int[] inDegree = new int[taskNum];//入度 任务的前置任务数
        List<List<Integer>>  outDegree = new ArrayList<List<Integer>>(taskNum); //出度 每个任务的依赖任务
        for (int i = 0; i < taskNum; i++) {
            outDegree.add(new ArrayList<Integer>());
        }

        //初始化入度出度

        for (int i = 0; i < relationsNum; i++) {
            outDegree.get(relation[i][0]).add(relation[i][1]);
            inDegree[relation[i][1]] = inDegree[relation[i][1]]+1;
        }

        LinkedList<Integer[]> queue = new LinkedList<>();
        int res = 1;
        for (int i = 0; i < taskNum; i++) {

            if(inDegree[i]==0){
                queue.add(new Integer[]{i,res});
            }
        }
        while (queue.size()>0){
            Integer[] curTask = queue.removeFirst();
            int task = curTask[0];
            int time = curTask[1];
            for (Integer integer : outDegree.get(task)) {
                inDegree[integer] = --inDegree[integer];
                if (inDegree[integer] == 0) {
                    res = time + 1;
                    queue.add(new Integer[]{integer, res});
                }
            }
        }
        return res;

    }*/
    /*    class Solution {
            public int minimumTime(int n, int[][] relations, int[] time) {
                int[] du = new int[n + 1];
                int[] ans = new int[n + 1];
                List<List<Integer>> graph = new ArrayList<>();
                for(int i = 0; i <= n; i++) {
                    graph.add(new ArrayList<>());
                }
                for(int[] relation: relations) {
                    graph.get(relation[0]).add(relation[1]);
                    du[relation[1]]++;
                }
                Queue<Integer> que = new LinkedList<>();
                for(int i = 1; i <= n; i++) {
                    if(du[i] == 0) {
                        que.add(i);
                        ans[i] = time[i-1];
                    }
                }
                while(!que.isEmpty()) {
                    int t = que.poll();
                    for(Integer v: graph.get(t)) {
                        du[v]--;
                        ans[v] = Math.max(ans[v], ans[t] + time[v-1]);
                        if(du[v] == 0) {
                            que.add(v);
                        }
                    }
                }
                int res = 0;
                for(int i = 1; i <= n; i++) {
                    res = Math.max(res, ans[i]);
                }
                return res;
            }
        }*/

    //7 统计友好度最大值
    /*    public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            String input = sc.nextLine();
            String[] sArr = input.split(" ");
            Integer[] arr = new Integer[sArr.length];
            for(int i = 0;i < sArr.length;i++){
                arr[i] = Integer.parseInt(sArr[i]);
            }
            int index = -1;
            int score = 0;
            int[] res = new int[]{-1,-1};
            boolean flag = false;
            for (int i = 0; i < arr.length; i++) {
                if(arr[i]==2){
                    if(score >res[1]){
                        res[0] = index;
                        res[1] = score;
                        score = 0;
                        index = -1;
                    }else {
                        score = 0;
                    }
                }
                if(arr[i]==1){
                    score++;
                }
                if(arr[i]==0){
                    if(flag){
                        if(score >res[1]){
                            res[0] = i;
                            res[1] = score;
                            score = i - index -1;
                            index = i;
                        }else {
                            score = i - index -1;
                            index = i;
                        }
                        flag = false;
                    }else {
                        index = i;
                        flag =true;
                    }
                }
            }
            System.out.println(res[0]+1+" : "+res[1]);
        }*/

    //8 荒地建设电站 / 区域发电量统计/探索地块建立
    /*    public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int l = sc.nextInt(); //长
            int w = sc.nextInt(); //宽
            int s = sc.nextInt(); //正方形边长
            int M = sc.nextInt();//发电量
            Integer[][] arr = new Integer[l][w];
            for (int i = 0; i < l; i++) {
                for (int j = 0; j < w; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }
            if(l<s || w< s){
                System.out.println(0);
                return;
            }
            int sum = 0;
            int result = 0;
            for(int i = 0; i< l-s+1;i++){
                for (int j = 0;j<w-s+1;j++){
                    sum = 0;
                    for (int k = 0; k < s; k++) {
                        for (int z = 0; z < s; z++) {
                            sum+=arr[i+k][j+z];
                        }
                    }

                    System.out.println(sum+" "+i+","+j);

                    if (sum>=M){
                        result++;
                        System.out.println("result:"+i+","+j);
                    }
                }
            }
            System.out.println(result);
        }*/

    //9 最大连续文件之和 / 区块链文件转储系统 滑动窗口
    /*    public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int M = sc.nextInt();
            sc.nextLine();
            String line = sc.nextLine();
            String[] split = line.split(" ");
            Integer[] arr = new Integer[split.length];
            int res = M;
            for (int i = 0; i < split.length; i++) {
                arr[i] = Integer.parseInt(split[i]);
            }

            for (int i = 0; i < arr.length; i++) {
                int index = i;
                int sum = arr[i];
                while (sum < M && index+1 < arr.length){
                    index++;
                    sum+=arr[index];
                    if(sum>M){
                        sum-=arr[index];
                        break;
                    }
                }
                if(M-sum<res){
                    res = M-sum;
                }
            }
            System.out.println(M-res);
        }*/

    //10发现新词的数量 /新词挖掘
    /*    public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            String content = sc.nextLine();
            String word = sc.nextLine();
            char[] chars = word.toCharArray();
            HashMap<String, Integer> keyTimes = new HashMap<>();
            for (int i = 0; i < chars.length; i++) {
                String key = String.valueOf(chars[i]);
                if(keyTimes.get(key)!=null){
                    keyTimes.put(key, keyTimes.get(key)+1);
                }
                keyTimes.put(key,1);
            }
            char[] contents = content.toCharArray();
            int res = 0;
            for (int i = 0; i < contents.length-chars.length+1; i++) {
                String substring = content.substring(i, i + chars.length);
                HashMap<String, Integer> clone = (HashMap<String, Integer>)keyTimes.clone();
                if(judge(substring,clone)){
                    res++;
                }
            }
            System.out.println(res);
        }

        private static boolean judge(String substring, HashMap<String, Integer> keyTimes) {
            char[] chars = substring.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                String key = String.valueOf(chars[i]);
                if(keyTimes.get(key)==null||keyTimes.get(key)==0){
                    return false;
                }else {
                    Integer value = keyTimes.get(key);
                    keyTimes.put(key,value-1);
                }
            }
            return true;
        }*/

    //11最大输出功率的设备 /查找充电设备组合
    /*    public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            Integer[] p = new Integer[n];
            for (int i = 0; i < n; i++) {
                p[i] = sc.nextInt();
            }
            int Pmax = sc.nextInt();
            int[][] dp = new int[n+1][Pmax+1];
            for (int i = Pmax; i >= p[0]; i--) {
                dp[0][i] = dp[0][i-p[0]]+p[0];
            }
            for (int i = 1; i < n; i++) {
                for (int j = 0; j <= Pmax; j++) {
                    if(j-p[i]<0){
                        dp[i][j]=dp[i-1][j];
                    }else {
                        dp[i][j]=Math.max(dp[i-1][j],dp[i-1][j-p[i]]+p[i]);
                    }

                }
            }
            for (int[] integers : dp) {
                System.out.println(Arrays.toString(integers));
            }
        }*/

    //12上班之路，dfs难顶没做
    /*    public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            int c = sc.nextInt();
            int n = sc.nextInt();
            int m = sc.nextInt();
            sc.nextLine();
            char[][] map = new char[n][m];
            int startx = 0;
            int starty = 0;
            for (int i = 0; i < n; i++) {
                String s = sc.nextLine();
                char[] line = s.toCharArray();
                for (int j = 0; j < line.length; j++) {
                    if(line[j]=='S'){
                        startx = j;
                        starty = i;
                    }
                }
                map[i] = line;
            }




        }
        static void dfs(int i,int j,int t,int c,
                           char[][] map,boolean flag){
            //向下
            if(map[i][j]=='T'){
                flag = true;
                return;
            }
            if((map[i][j]=='*'&& c>0)||
                    (map[i][j]=='.')){

            }
            //向右
            }
        }*/

    //13 简单的解压缩算法
    /*    public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            String input = sc.nextLine();
            char[] chars = input.toCharArray();
            Stack<String> stack = new Stack<>();
            for (int i = 0; i < chars.length; i++){
                if (chars[i] =='{') {
                    stack.push(String.valueOf(chars[i]));
                }else if(chars[i]=='}'){
                    ArrayList<String> numChar = new ArrayList<>();
                    ArrayList<String> strChar = new ArrayList<>();
                    while (i+1 < chars.length && '0' <= chars[i + 1] && chars[i + 1] <= '9') {
                        i++;
                        numChar.add(String.valueOf(chars[i]));
                    }
                    StringBuilder sb = new StringBuilder();
                    for (int j = 0; j < numChar.size(); j++) {
                        sb.append(numChar.get(j));
                    }
                    int num = Integer.valueOf(sb.toString());
                    while (!stack.empty()){
                        if(!stack.peek().equals("{")){
                            strChar.add(stack.pop());
                        }else {
                            stack.pop();
                            break;
                        }
                    }
                    StringBuilder sb2 = new StringBuilder();

                    for (int j = strChar.size()-1; j >= 0; j--) {
                        sb2.append(strChar.get(j));
                    }
                    String str = sb2.toString();
                    for (int j = 0; j < num; j++) {
                        stack.push(str);
                    }
                }else if('0'<=chars[i]&&chars[i]<='9'){
                    ArrayList<Character> numChar = new ArrayList<>();
                    numChar.add(chars[i]);
                    while (i+1 < chars.length&&'0'<=chars[i+1]&&chars[i+1]<='9'){
                        i++;
                        numChar.add(chars[i]);
                    }
                    StringBuilder sb = new StringBuilder();
                    for (int j = 0; j < numChar.size(); j++) {
                        sb.append(numChar.get(j));
                    }
                    int num = Integer.valueOf(sb.toString());
                    String ch = stack.pop();
                    for (int j = 0; j < num; j++) {
                        stack.push(ch);
                    }
                }else {
                    stack.push(String.valueOf(chars[i]));
                }
            }
            ArrayList<String> res = new ArrayList<String>();
            while (!stack.empty()){
                res.add(stack.pop());
            }
            Collections.reverse(res);
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < res.size(); i++) {
                builder.append(res.get(i));
            }
            System.out.println(builder.toString());
        }*/

    //14机房布局
    /*public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        if (input.contains("MMM")||input.startsWith("MM")||input.endsWith("MM")){
            System.out.println("-1");
            return;
        }
        int n = input.length();
        int res = 0;
        boolean flag =false;
        for (int i = 0; i < n; i++) {
            if(input.charAt(i)=='M'){
                res++;
                if(i>=2&&input.charAt(i-1)=='I'&&input.charAt(i-2)=='M'){
                    if(flag){
                        flag=false;
                    }else {
                        res--;
                        flag=true;
                    }
                }
            }
        }
        System.out.println(res);
    }*/

    //15缓存需要最少金币数 /静态扫描
    /*public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        sc.nextLine();
        String F = sc.nextLine();
        String S = sc.nextLine();
        String[] f = F.split(" ");
        String[] s = S.split(" ");
        int res = 0;
        HashMap<String, Integer> timeMap = new HashMap<>();
        HashMap<String, Integer> valueMap = new HashMap<>();
        for (int i = 0; i < f.length; i++) {
            Integer time = timeMap.getOrDefault(f[i],0);
            Integer value = valueMap.getOrDefault(f[i],0);
            if(value==0){
                valueMap.put(f[i],Integer.parseInt(s[i]));
            }
            timeMap.put(f[i],time+1);
        }
        for (String key : timeMap.keySet()) {
            Integer time = timeMap.get(key);
            Integer value = valueMap.get(key);
            if(time*value>=M+value){
                res+=M+value;
            }else {
                res+=time*value;
            }
        }
        System.out.println(res);
    }*/

    //16快递投放问题
    /*public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int N = sc.nextInt();
        sc.nextLine();
        HashMap<String, String> map = new HashMap<>();
        for (int i = 0; i < M; i++) {
            String msg = sc.nextLine();
            String[] s = msg.split(" ");
            map.put(s[0],s[1]+s[2]);
        }
        for (int i = 0; i < N; i++) {
            String msg = sc.nextLine();
            String[] s = msg.split(" ");
            String s1 = map.get(s[2]);
            if(s1.equals(s[0]+s[1])||s1.equals(s[1]+s[0])){
                map.remove(s[2]);
            }
        }
        if (map.size()==0){
            System.out.println("none");
            return;
        }
        for (String s : map.keySet()) {
            System.out.println(s);
        }
    }*/

    //17优秀学员统计
    /*public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int max = 1;
        HashMap<Integer, Integer[]> map = new HashMap<>();
        for (int i = 0; i < num; i++) {
            int start = sc.nextInt();
            if(start>max){
                max = start;
            }
            int end = sc.nextInt();
            if(end>max){
                max=end;
            }
            map.put(i,new Integer[]{start,end});
        }
        for (int i = 0; i < num; i++) {
            Integer[] msg = map.get(i);
            if(msg[0]>msg[1]){
                map.put(i,new Integer[]{msg[0],max});
                map.put(num+i,new Integer[]{1,msg[1]});
            }
        }
        HashMap<Integer, Integer> times = new HashMap<>();
        for (Integer[] startEnd : map.values()) {
            for (Integer i = startEnd[0]; i <= startEnd[1]; i++) {
                Integer time = times.getOrDefault(i, 0);
                times.put(i,time+1);
            }
        }
        int max2 = 0;
        int res = 0;
        for (Integer key : times.keySet()) {
            if(times.get(key)>max2){
                max2=times.get(key);
                res = key;
            }
        }
        System.out.println(res);
    }*/

    //18寻找相似单词
    /*    public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();
            sc.nextLine();
            ArrayList<String> stringArrayList = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                stringArrayList.add(sc.nextLine());
            }
            String target = sc.nextLine();
            String tar = sort(target);
            int length = target.length();
            boolean flag = false;
            for (int i = 0; i < stringArrayList.size(); i++) {
                String s = stringArrayList.get(i);
                if(s.length()==length&&tar.equals(sort(s))){
                    System.out.print(s+" ");
                    flag =true;
                }
            }
            if(!flag){
                System.out.println("null");
            }

        }

        static String sort(String s){
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < chars.length; i++) {
                sb.append(chars[i]);
            }
            return sb.toString();
        }*/

    //19羊、狼、农夫过河
    /*public static int min_time;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();//羊的数量
        int n = sc.nextInt();//狼的数量
        int x = sc.nextInt();//载重
        if(n>m){
            //狼大于羊
            System.out.println(0);
            return;
        }
        min_time = (m+n)*x;
        //已经运输的
        int tempm = 0;
        int tempn = 0;
        dfs(m,n,x,tempm,tempn,0);
        System.out.println(min_time);
    }

    public static int dfs(int m, int n, int x,
                          int tempm, int tempn, int time){
        if(m+n<=x){
            if(time+1<min_time){
                min_time = time+1;
            }
            return time+1;
        }
        for (int i = 0; i <= m && i<=x; i++) {
            for (int j = 0; j <= n && i+j<=x; j++) {
                if(i+j==0){
                    continue;
                }
                if(((m-i==0||m-i>n-j))&&(tempm+i==0||(tempm+i>tempn+j))){
                    int res = dfs(m-i,n-j,x,tempm+i,tempn+j,time+1);
                    if (res<min_time&&res!=0){
                        min_time = res;
                    }
                }
            }
        }
        return 0;
    }*/

    //20严格递增字符串
    /*public static int main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        char[] chars = s.toCharArray();
        int len = s.length();
        int[][] dp = new int[len][2];
        dp[0][0]=(chars[0]=='0'?0:1);
        dp[1][0]=(chars[0]=='1'?0:1);
        for (int i = 1; i < chars.length; i++) {
            dp[i][0]=dp[i-1][0]+(chars[i]=='0'?0:1);
            dp[i][1]=Math.min(dp[i-1][0],dp[i-1][1])+(chars[i]=='1'?0:1);
        }
        return Math.min(dp[len-1][0],dp[len-1][1]);
    }*/

    //21微服务的集成测试
    /*public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][n];
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        int k = sc.nextInt();
        int res=dfs(arr,visited,k-1);
        System.out.println(res);
    }
    static int dfs(int[][] arr,boolean[] visited,int i){
        if(visited[i]){
            return 0;
        }
        int res = arr[i][i];
        visited[i]=true;
        for (int j = 0; j < arr.length; j++) {
            if(j!=i&&arr[i][j]==1){
                res+=dfs(arr,visited,j);
            }
        }
        return res;
    }*/



}
