package com.errordataredis.redisviews;

//import com.errordataredis.redisviews.dao.DataBasesMessageRemotedtfDao;
//import com.errordataredis.redisviews.dao.DataBasesMessageRpulsedtfDao;
//import com.errordataredis.redisviews.dao.DateBasesMessageTelemetrydtfDao;
//import com.errordataredis.redisviews.entity.Telemetrydtf;
import org.junit.jupiter.api.Test;
        import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = RedisviewsApplication.class)
class RedisviewsApplicationTests {
//    @Autowired
//    private DateBasesMessageTelemetrydtfDao dateBasesMessageTelemetrydtfDao;
//    @Autowired
//    private DataBasesMessageRemotedtfDao dataBasesMessageRemotedtfDao;
//    @Autowired
//    private DataBasesMessageRpulsedtfDao dataBasesMessageRpulsedtfDao;



    @Test
    void contextLoads() {
      /*  //条件查询
        Specification<Telemetrydtf> specification = new Specification<Telemetrydtf>() {
            @Override
            public Predicate toPredicate(Root<Telemetrydtf> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                Path<Object> telemetrydtfStationNumber = root.get("telemetrydtfUNumber");

                Predicate predicate = criteriaBuilder.equal(telemetrydtfStationNumber, "16506");
                return predicate;
            }
        };
        Optional<Telemetrydtf> one = dateBasesMessageTelemetrydtfDao.findOne(specification);
        System.out.println(one);
        */
//        System.out.println(dataBasesMessageRpulsedtfDao.findAll());
//        System.out.println(dataBasesMessageRemotedtfDao.findAll());
//        System.out.println(dateBasesMessageTelemetrydtfDao.findAll().get(0));
//        System.out.println(overdata.findAll());
//        System.out.println(dateBasesMessageTelemetrydtfDao.findByTelemetrydtfStationNumber("630056"));
//        System.out.println("开始.....");
//        long endtimeMillis = System.currentTimeMillis();
//        Telemetrydtf byTelemetrydtfUNumber = dateBasesMessageTelemetrydtfDao.findByTelemetrydtfUDeviceNumberAndTelemetrydtfUNumber("630016870","16753");
//        System.out.println(byTelemetrydtfUNumber);
//        System.out.println(dataBasesMessageRpulsedtfDao.findByRpulsedtfUDeviceNumberAndRpulsedtfUNumber("630033905", "25616"));
//        System.out.println(dataBasesMessageRemotedtfDao.findByRemotedtfUDeviceNumberAndRemotedtfUNumber("630037901", "1"));
//        long odertimeMillis = System.currentTimeMillis();
//        System.out.println("所用耗时："+(odertimeMillis-endtimeMillis)+"豪秒");
//        Remotedtf byRemotedtfUDeviceNumberAndRemotedtfUNumber = dataBasesMessageRemotedtfDao.findByRemotedtfUDeviceNumberAndRemotedtfUNumber("630084127", "7012");
//        System.out.println(byRemotedtfUDeviceNumberAndRemotedtfUNumber);

//        List<Remotedtf> all = dataBasesMessageRemotedtfDao.findAll();
//        List<Rpulsedtf> all1 = dataBasesMessageRpulsedtfDao.findAll();
//        List<Telemetrydtf> all2 = dateBasesMessageTelemetrydtfDao.findAll();
//
//        System.out.println("x");
//        Scanner scanner = new Scanner(System.in);
//        String nextLine = scanner.nextLine();
//        if (nextLine.equals("exit")){
//            return;
//        }
//        System.out.println("初始化完毕......");
//        System.out.println(DataBasesMsgCollection.RPULSEDTFCollection.size());
//        System.out.println(DataBasesMsgCollection.TELEMETRYDTFCollection.size());
//        System.out.println(DataBasesMsgCollection.REMOTEDTFCollection.size());
//
//        function((List) DataBasesMsgCollection.TELEMETRYDTFCollection);


//    }
//    public void function(List obj) {
//        Object o =  obj.get(0);
//
//        Rpulsedtf rpulsedtf = null;
//        for (Object o1 : obj) {
//             rpulsedtf = (Rpulsedtf) o1;
//        }
//
//
//
//
//
//        if (o instanceof Rpulsedtf) {
//            System.out.println("Rpulsedtf"+o);
//        }else if (o  instanceof  Remotedtf){
//            System.out.println("Remotedtf"+o);
//        }else if (o instanceof Telemetrydtf){
//            System.out.println("Telemetrydtf"+o);
//        }
//
    }




}
