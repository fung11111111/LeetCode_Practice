package javaBasic.threads;

import kotlin.Pair;

import javax.imageio.plugins.tiff.TIFFImageReadParam;
import java.util.concurrent.*;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class CompletableFutureThread {
    //completablefuture vs executor service
    //executor service can init the pool size, scheduling...
    //


    public class RunAsyncExample {
        public void delay(int seconds) {
            try {
                TimeUnit.SECONDS.sleep(seconds);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        public void mainFunc() {
            ExecutorService executorService = Executors.newCachedThreadPool();
            Runnable runnable = () -> {
                delay(1);
                System.out.println("I am runnable - " + Thread.currentThread().getName());
            };

            CompletableFuture<Void> completableFuture = CompletableFuture.runAsync(runnable, executorService);

            System.out.println("I am main - " + Thread.currentThread().getName());
            completableFuture.join();
        }
    }

    public class SupplyAsyncExample {
        public void delay(int seconds) {
            try {
                TimeUnit.SECONDS.sleep(seconds);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        public void mainFunc() {
            //supplier can be return object or return null for void only
            Supplier<Void> supplier = () -> {
                delay(1);
                System.out.println("I am in supplier - " + Thread.currentThread().getName());
                //  return "From Supplier";
                return null;
            };

            CompletableFuture<Void> completableFuture = CompletableFuture.supplyAsync(supplier);
            System.out.println("I am main - " + Thread.currentThread().getName());

            completableFuture.join();

            //System.out.println("value - " + value);
        }
    }

    public class CallBackExample {
        public void delay(int seconds) {
            try {
                TimeUnit.SECONDS.sleep(seconds);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        public void mainFunc() {

            // supplyAsync -> to init concurrent action and return
            // thenApply need to take the param as input
            // thenAccept need to take the param as input
            // thenRun no need to take the param as input
            //need to use join to back to the main thread
            CompletableFuture<Void> completableFuture = CompletableFuture.supplyAsync(() -> {
                delay(2);
                System.out.println("running middle task");
                return "Tech Recipes";
            }).thenApply(str -> {
                return "Hello " + str;
            }).thenApply(str -> {
                return 1;
            }).thenAccept(num -> {
                System.out.println(num);
            });


            System.out.println("I am main - " + Thread.currentThread().getName());
            completableFuture.join();
        }

    }

    public class ComposeExample {
        // compose is to link different thread together and pass the parameter
        public void delay(int seconds) {
            try {
                TimeUnit.SECONDS.sleep(seconds);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        public CompletableFuture<String> getUserDetail() {
            return CompletableFuture.supplyAsync(() -> {
                System.out.println("getUserDetail() - " + Thread.currentThread().getName());
                delay(3);
                return "UserDetails";
            });
        }

        public CompletableFuture<String> getWishList(String user) {
            return CompletableFuture.supplyAsync(() -> {
                System.out.println("getWishList(): " + user + " - " + Thread.currentThread().getName());
                delay(1);
                return "User WishList";
            });
        }

        public void mainFunc() {
            long startTime = System.currentTimeMillis();
            CompletableFuture<String> output = getUserDetail().thenCompose(s -> {
                return getWishList(s);
            });
            System.out.println("I am main - " + Thread.currentThread().getName());
            delay(4);
            System.out.println(output.join());
            long endTime = System.currentTimeMillis();
            System.out.println("It takes: " + (endTime - startTime));
        }

    }

    public class CombineExample {
        public void delay(int seconds) {
            try {
                TimeUnit.SECONDS.sleep(seconds);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        public CompletableFuture<String> getEmail() {
            return CompletableFuture.supplyAsync(() -> {
                delay(3);
                System.out.println("getEmail() - " + Thread.currentThread().getName());
                return "abc@gamil.com";
            });
        }

        public CompletableFuture<String> getReport() {
            return CompletableFuture.supplyAsync(() -> {
                delay(3);
                System.out.println("getReport() - " + Thread.currentThread().getName());
                return "report.xlsx";
            });
        }

        public CompletableFuture<String> getTarget() {
            return CompletableFuture.supplyAsync(() -> {
                delay(1);
                System.out.println("getTarget() - " + Thread.currentThread().getName());
                return "David Tommy";
            });
        }

        public void mainFunc() {
            long startTime = System.currentTimeMillis();

            CompletableFuture<Void> completableFuture = getEmail().thenCombine(getReport(), (e, r) -> {
                System.out.println(String.format("send to {%s} with report {%s}", e, r));
                return null;
            });




            System.out.println("I am main - " + Thread.currentThread().getName());
            delay(1);
            completableFuture.join();
            long endTime = System.currentTimeMillis();
            System.out.println("It takes: " + (endTime - startTime));
        }

    }

    public class AnyAllofExample {
        public void delay(int seconds) {
            try {
                TimeUnit.SECONDS.sleep(seconds);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        public CompletableFuture<String> future1() {
            return CompletableFuture.supplyAsync(() -> {
                delay(2);
                System.out.println("future1() - " + Thread.currentThread().getName());
                return "1";
            });
        }

        public CompletableFuture<String> future2() {
            return CompletableFuture.supplyAsync(() -> {
                delay(4);
                System.out.println("future2() - " + Thread.currentThread().getName());
                return "2";
            });
        }

        public CompletableFuture<String> future3() {
            return CompletableFuture.supplyAsync(() -> {
                delay(1);
                System.out.println("future3() - " + Thread.currentThread().getName());
                return "3";
            });
        }

        public void mainFunc() {
            CompletableFuture<Void> completableFuture = CompletableFuture.allOf(future1(), future2(), future3());
            completableFuture.join();

//            CompletableFuture<Object> completableFuture2 = CompletableFuture.anyOf(future1(), future2(), future3());
//            System.out.println(completableFuture2.join());

        }
    }

    public class ExceptionHandlingExample {
        public void mainFunc() {
            boolean err = true;
//            CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(()-> {
//                if(err) throw new RuntimeException("Error in future");
//                return "Success";
//            }).handle((msg, exception) -> {
//                if(exception != null){
//                    System.out.println(exception.getMessage());
//                    return null;
//                }
//                return msg;
//            });

            CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> {
                if (err) throw new RuntimeException("Error in future");
                return "Success";
            }).exceptionally(e -> {
                System.out.println(e.getMessage());
                return null;
            });
            System.out.println(completableFuture.join());

        }
    }

    public void client() {
//        RunAsyncExample runAsyncExample = new RunAsyncExample();
//        runAsyncExample.mainFunc();

//        SupplyAsyncExample supplyAsyncExample = new SupplyAsyncExample();
//        supplyAsyncExample.mainFunc();

//        CallBackExample callBackExample = new CallBackExample();
//        callBackExample.mainFunc();

//        ComposeExample composeExample = new ComposeExample();
//        composeExample.mainFunc();

        CombineExample combineExample = new CombineExample();
        combineExample.mainFunc();
//
//        AnyAllofExample anyAllofExample = new AnyAllofExample();
//        anyAllofExample.mainFunc();

//        ExceptionHandlingExample exceptionHandlingExample = new ExceptionHandlingExample();
//        exceptionHandlingExample.mainFunc();
    }
}
