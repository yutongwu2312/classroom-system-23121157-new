// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: mobile.proto

package com.classroomsystem;

public final class MobileProto {
  private MobileProto() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    String[] descriptorData = {
      "\n\014mobile.proto\022\tmobileapp\032\013light.proto\032\016" +
      "computer.proto2\232\002\n\020MobileAppService\022:\n\016G" +
      "etLightStatus\022\022.light.LightStatus\032\022.ligh" +
      "t.LightStatus\"\000\0227\n\013ToggleLight\022\022.light.L" +
      "ightStatus\032\022.light.LightStatus\"\000\022I\n\021GetC" +
      "omputerStatus\022\030.computer.ComputerStatus\032" +
      "\030.computer.ComputerStatus\"\000\022F\n\016ToggleCom" +
      "puter\022\030.computer.ComputerStatus\032\030.comput" +
      "er.ComputerStatus\"\000B$\n\023com.classroomsyst" +
      "emB\013MobileProtoP\000b\006proto3"
    };
    com.google.protobuf.Descriptors.FileDescriptor.InternalDescriptorAssigner assigner =
        new com.google.protobuf.Descriptors.FileDescriptor.    InternalDescriptorAssigner() {
          public com.google.protobuf.ExtensionRegistry assignDescriptors(
              com.google.protobuf.Descriptors.FileDescriptor root) {
            descriptor = root;
            return null;
          }
        };
    com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
          LightProto.getDescriptor(),
          ComputerProto.getDescriptor(),
        }, assigner);
    LightProto.getDescriptor();
    ComputerProto.getDescriptor();
  }

  // @@protoc_insertion_point(outer_class_scope)
}
