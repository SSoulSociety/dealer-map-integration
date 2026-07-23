//
//  ContentView.swift
//  pasaj
//

import SwiftUI

struct ContentView: View {
    @State private var locationManager = LocationManager()
    @AppStorage("hasSeenOnboarding") private var hasSeenOnboarding = false

    var body: some View {
        Group {
            if hasSeenOnboarding {
                mainTabView
            } else {
                OnboardingView(locationManager: locationManager) {
                    hasSeenOnboarding = true
                }
            }
        }
        .environment(locationManager)
    }

    private var mainTabView: some View {
        TabView {
            PasajView()
                .tabItem { Label("Pasaj", systemImage: "shippingbox") }

            IslemlerView()
                .tabItem { Label("İşlemler", systemImage: "checklist") }

            ChatView()
                .tabItem { Label("Sohbet", systemImage: "message") }
        }
        .tint(AppTheme.gold)
        .preferredColorScheme(.dark)
    }
}

#Preview {
    ContentView()
}
