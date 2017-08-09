cmake_minimum_required(VERSION 3.1.0)
project(FindSmallestCommonNumber)
add_definitions(-DUSE_EXPORT_KEYWORD)
set(SRC_FILES
    main.cpp
    )
# force c++11
set(CMAKE_CXX_STANDARD 11)
add_executable(FindSmallestCommonNumber ${SRC_FILES})
