// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: wso2/discovery/config/enforcer/cert.proto

package org.wso2.gateway.discovery.config.enforcer;

public final class CertStoreProto {
  private CertStoreProto() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }

  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistry registry) {
    registerAllExtensions(
        (com.google.protobuf.ExtensionRegistryLite) registry);
  }
  static final com.google.protobuf.Descriptors.Descriptor
    internal_static_discovery_config_enforcer_CertStore_descriptor;
  static final 
    com.google.protobuf.GeneratedMessageV3.FieldAccessorTable
      internal_static_discovery_config_enforcer_CertStore_fieldAccessorTable;

  public static com.google.protobuf.Descriptors.FileDescriptor
      getDescriptor() {
    return descriptor;
  }
  private static  com.google.protobuf.Descriptors.FileDescriptor
      descriptor;
  static {
    java.lang.String[] descriptorData = {
      "\n)wso2/discovery/config/enforcer/cert.pr" +
      "oto\022\031discovery.config.enforcer\"=\n\tCertSt" +
      "ore\022\020\n\010location\030\001 \001(\t\022\014\n\004type\030\002 \001(\t\022\020\n\010p" +
      "assword\030\003 \001(\tB\216\001\n*org.wso2.gateway.disco" +
      "very.config.enforcerB\016CertStoreProtoP\001ZN" +
      "github.com/envoyproxy/go-control-plane/w" +
      "so2/discovery/config/enforcer;enforcerb\006" +
      "proto3"
    };
    descriptor = com.google.protobuf.Descriptors.FileDescriptor
      .internalBuildGeneratedFileFrom(descriptorData,
        new com.google.protobuf.Descriptors.FileDescriptor[] {
        });
    internal_static_discovery_config_enforcer_CertStore_descriptor =
      getDescriptor().getMessageTypes().get(0);
    internal_static_discovery_config_enforcer_CertStore_fieldAccessorTable = new
      com.google.protobuf.GeneratedMessageV3.FieldAccessorTable(
        internal_static_discovery_config_enforcer_CertStore_descriptor,
        new java.lang.String[] { "Location", "Type", "Password", });
  }

  // @@protoc_insertion_point(outer_class_scope)
}