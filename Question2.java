import java.util.*;

class Question2{
    class User{
        int serialNo;
        String name;
        String panNo;
        int amount;
        public User() {
        }
        public User(int serialNo, String name, String panNo, int amount) {
            this.serialNo = serialNo;
            this.name = name;
            this.panNo = panNo;
            this.amount = amount;
        }
        public int getSerialNo() {
            return serialNo;
        }
        public void setSerialNo(int serialNo) {
            this.serialNo = serialNo;
        }
        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }
        public String getPanNo() {
            return panNo;
        }
        public void setPanNo(String panNo) {
            this.panNo = panNo;
        }
        public int getAmount() {
            return amount;
        }
        public void setAmount(int amount) {
            this.amount = amount;
        }
        @Override
        public String toString() {
            return "User [serialNo=" + serialNo + ", name=" + name + ", panNo=" + panNo + ", amount=" + amount + "]";
        }
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        String input[]=sc.nextLine().split(" ");
        int n=Integer.parseInt(input[0]);
        int q=Integer.parseInt(input[1]);
        List<User> records=new ArrayList<User>();               // For Records
        Question2 x=new Question2();
        for(int i=0;i<n;i++){
            String str=sc.nextLine();
            String strs[]=str.split(",");
            User user=x.new User();                             // Each entry into separate record or object
            user.setSerialNo(Integer.parseInt(strs[0]));
            user.setName(strs[1]);
            user.setPanNo(strs[2]);
            user.setAmount(Integer.parseInt(strs[3]));
            records.add(user);
        }
        for(int i=0;i<q;i++){
            int key=sc.nextInt();
            switch (key) {
                case 1:                                 // S :Search whether the records(given data ) for a Name S exist
                    String name=sc.next();
                    boolean b=false;
                    for(int j=0;j<n;j++){
                        if(records.get(j).name.equals(name)){
                            b=true;
                            break;
                        }
                    }
                    if(b)
                        System.out.println("1");
                    else
                        System.out.println("0");
                    break;

                case 2:                                //S :Search whether the records for a Pan number S exist.
                    String pan=sc.next();
                    boolean b2=false;
                    for(int j=0;j<n;j++){
                        if(records.get(j).panNo.equals(pan)){
                            b2=true;
                            break;
                        }
                    }
                    if(b2)
                        System.out.println("1");
                    else
                        System.out.println("0");
                    break;
                
                case 3:                                 //S :Search the records for a Pan number prefix S and return all matching records
                    String prefix=sc.next();
                    List<String> list=new ArrayList<String>();
                    for(int j=0;j<n;j++){
                        if(prefix.compareTo(records.get(j).panNo.substring(0,9))==0){
                            list.add(records.get(j).getPanNo());
                        }
                    }
                    if(list.size()==0){
                        System.out.println("[]");
                    }
                    else{
                        StringBuilder sb=new StringBuilder();
                        sb.append("[");
                        for(int j=0;j<list.size();j++){
                            sb.append(list.get(j)+",");
                        }
                        sb.deleteCharAt(sb.length() - 1);
                        sb.append("]");
                        System.out.println(sb.toString());
                    }
                   break;

                case 4:                             // L R x:Update Amount of <L,R> by x; L,Rϵ <S.No>, xϵ <int>
                    int l=sc.nextInt();
                    int r=sc.nextInt();
                    int amount=sc.nextInt();
                    for(int j=l-1;j<r;j++){
                        Question2.User user=records.get(j);
                        user.setAmount(user.getAmount()+amount);
                        records.set(j, user);
                    }
                    break;

                case 5:                            //  L R :Return withdrawal amount sum for <L,R> withdrawal amount=amount/5 and its ceil
                    int left=sc.nextInt();
                    int right=sc.nextInt();
                    int res=0;
                    for(int j=left-1;j<right;j++){
                        double am=records.get(j).getAmount();
                        res=res+(int)Math.ceil(am/5);
                    }
                    System.out.println(res);
                    break;

                default:
                    break;
            }
        }
        sc.close();
    }
}