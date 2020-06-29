/**

 * @author PHY
 * @date 2020-06-29$-13:10
 *
 */
class testProperty {


    public void test01()
    {
        InputStream inputStream = null;
        try {
            Properties pro = new Properties();
            inputStream = new FileInputStream "JDBC.properties";
            pro.load(inputStream);

            String username = pro . getProperty "username";
            String password = pro . getProperty "password";
            System.out.println(username);
            System.out.println(password);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }
}