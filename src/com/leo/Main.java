package com.leo;

import com.leo.utils.DataUtil;

import java.util.List;

/**
 * Created by apple on 2017/12/18.
 */
public class Main {

    public static void main(String[] args) {

//        DataUtil.extractData();

        Graph graph = new Graph();
        graph.buildGraph();
        Point query = new Point(0);
        int k = 2;
        KCore kcore = new KCore(graph, k, query);
        List<Point> points = kcore.findKCore();
//        Exact exact = new Exact();
//        List<Point> result = exact.calc(points, query, graph, k);
//        System.out.println("result->" + result);
//        executeAppInc(query, graph, k);
        executeAppFast(query, graph, k, 0.5);
        executeExact(points, query, graph, k);
    }

    public static void executeAppFast(Point query, Graph graph, int k, double epsilon) {
        AppFast appFast = new AppFast();
        List<Point> result = appFast.calc(query, graph, k, epsilon);
        System.out.println("result->" + result);
    }

    public static void executeAppInc(Point query, Graph graph, int k) {
        AppInc appInc = new AppInc();
        List<Point> result = appInc.calc(query, graph, k);
        System.out.println("result->" + result);
    }

    public static void executeExact(List<Point> points, Point query, Graph graph, int k) {
        Exact exact = new Exact();
        List<Point> result = exact.calc(points, query, graph, k);
        System.out.println("result->" + result);
    }

}
