import { TestBed } from '@angular/core/testing';

import { SupervisorHubService } from './supervisor-hub.service';

describe('SupervisorHubService', () => {
  let service: SupervisorHubService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(SupervisorHubService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
