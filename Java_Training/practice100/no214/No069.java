package Java_Training.practice100.no214;
import java.io.IOException;
import java.rmi.ServerException;
import java.rmi.*;

//以下はリクエストパラメータの情報をModelクラスのインスタンスに変換し、JSON化して出力するサーブレットである。
//問題点を指摘し、修正せよ。なお、Modelクラスは適切な実装が与えられているものとする。
public class No069 extends HttpServlet {
    
    @Override
    public void doGet(HttpServletReqest req, HttpServletResponse res)
            throws ServerException, IOException {
        req.setCharacterEncoding("UTF-8");
        res.setContentType("application/json; charset=UTF-8");        

        Model m = new Model();
        // idをセットする。ただし、パラメータがない（null）の時は、空値とする。
        m.setId(req.getParameter("id") == null ? "" : req.getParameter("id"));

        // memoをメモとして取得・設定する（null値の場合はnullをセット） 
        m.setMemo(req.getParameter("memo"));;

        // yearParam1とyearParam2を数値に変換したとき、同じ値の場合にtrueをいれる
        //m.setTargetYear( Integer.valueOf(req.getParameter("yearParam1")) == Integer
                //.valueOf(req.getParameter("yearParam2")));
                var param1= req.getParameter("yearParam1");
                var param2= req.getParameter("yearParam2");

                if (param1 ==param2) {
                    return ;
                }
            
        res.getWriter().write(m.toJson());
            }
}