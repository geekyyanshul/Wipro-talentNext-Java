class Project1 {

    public static void main(String[] args) {

        if (args.length == 0) {
            System.out.println("Please enter employee id as command line argument.");
            return;
        }

        int id = Integer.parseInt(args[0]);
        int[] eno = {1001, 1002, 1003, 1004, 1005, 1006, 1007};
        String[] enm = {"Ashish", "Sushma", "Rahul", "Chahat", "Ranjan", "Suman", "Tanmay"};
        String[] doj = {"01/04/2009", "23/08/2012", "12/11/2008", "29/01/2013", "16/07/2005", "1/1/2000", "12/06/2006"};
        char[] dcode = {'e', 'c', 'k', 'r', 'm', 'e', 'c'};
        String[] dept = {"R&D", "PM", "Acct", "Front Desk", "Engg", "Manufacturing", "PM"};
        int[] basic = {20000, 30000, 10000, 12000, 50000, 23000, 29000};
        int[] hra = {8000, 12000, 8000, 6000, 20000, 9000, 12000};
        int[] it = {3000, 9000, 1000, 2000, 20000, 4400, 10000};

        boolean found = false;

        for (int i = 0; i < eno.length; i++) {
            if (id == eno[i]) {
                found = true;
                String desig = "";
                int da = 0;

                // Modern rule-switch
                switch (dcode[i]) {
                    case 'e' -> { desig = "Engineer"; da = 20000; }
                    case 'c' -> { desig = "Consultant"; da = 32000; }
                    case 'k' -> { desig = "Clerk"; da = 12000; }
                    case 'r' -> { desig = "Receptionist"; da = 15000; }
                    case 'm' -> { desig = "Manager"; da = 40000; }
                    default -> { desig = "Unknown"; da = 0; }
                }

                int sal = basic[i] + hra[i] + da - it[i];

                System.out.println("EmpNo\tEmpName\t\tDept\t\tDesignation\tDOJ\t\tSalary");
                System.out.println(eno[i] + "\t" + enm[i] + "\t\t" + dept[i] + "\t\t" + desig + "\t" + doj[i] + "\t" + sal);
                break;
            }
        }

        if (!found) {
            System.out.println("There is no employee with empid : " + id);
        }
    }
}
